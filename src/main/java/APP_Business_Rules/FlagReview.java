package APP_Business_Rules;

import Entities.Account;
import Entities.FlaggedReview;
import Entities.Review;
import Frameworks_and_Drivers.DataAccessStorage;

import java.util.ArrayList;


public class FlagReview {
    /**
     * Class responsible for the flagging of reviews as well as resolving the flag by either undoing a flag or
     * deleting the review.
     * @param review
     * @param flagger
     */

    public void flagged(Review review, Account flagger){
        /**
         * Flags a review and adds a FlaggedReview object to queue for later review.
         */
        review.flagReview();
        FlaggedReview flrev = new FlaggedReview(review, flagger);

        DataAccessStorage data = new DataAccessStorage();
        ArrayList<FlaggedReview> queue = (ArrayList<FlaggedReview>) data.accessData("FlaggedReviewQueue.ser");
        queue.add(flrev);
        data.storeData("FlaggedReviewQueue.ser", queue);
    }

    public void resolveFlag(boolean determination, FlaggedReview review){
        /**
         * Takes action based of the determination of the administrator regarding the reviews adherence to company
         * policy. true for the flagged reviews removal and false for the reversal of the flagged status.
         */
        archiveFlaggedReview(review);

        if (determination){
            deleteReview(review);
        }
        else {
            review.getFlagged().UnflagReview();
        }

    }

    public void deleteReview(FlaggedReview review){
        /**
         * Deletes review from everywhere except the archive.
         */
        review.getFlagged().getDishReviewed().removeReview(review.getFlagged());
        review.getFlagged().getAuthorAccount().removeReview(review.getFlagged());

        DataAccessStorage data = new DataAccessStorage();
        ArrayList<FlaggedReview> queue = (ArrayList<FlaggedReview>) data.accessData("FlaggedReviewQueue.ser");
        queue.remove(review);
        data.storeData("FlaggedReviewQueue.ser", queue);


    }
    public void archiveFlaggedReview(FlaggedReview review) {
        /**
         * Adds flagged review to archive of previously flagged reviews.
         */
        DataAccessStorage data = new DataAccessStorage();
        ArrayList<FlaggedReview> queue = (ArrayList<FlaggedReview>) data.accessData("FlaggedReviewArchive.ser");
        queue.add(review);
        data.storeData("FlaggedReviewArchive.ser", queue);
    }
}
