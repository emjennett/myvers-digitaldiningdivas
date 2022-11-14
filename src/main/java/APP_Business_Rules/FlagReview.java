package APP_Business_Rules;

import Entities.Account;
import Entities.FlaggedReview;
import Entities.Review;
import APP_Business_Rules.DataAccessStorageInterface;

public class FlagReview {

    public void flagged(Review review, Account flagger){
        //flags a review and adds a FlaggedReview object to queue for later review.
        review.flagReview();
        FlaggedReview flrev = new FlaggedReview(review, flagger);
        //**Will add to a queue for admin review when data storage is finished.
        List<> queue = accessData("FlaggedReviewQueue.ser");
        queue.add(flrev);
        storeData("FlaggedReviewQueue.ser", queue);
    }

    public void resolveFlag(boolean determination, FlaggedReview review){
        //Takes action based of the determination of the administrator regarding the reviews adherence to company
        // policy. true for the flagged reviews removal and false for the reversal of the flagged status.
        archiveFlaggedReview(review);
        //**add code for removing flagged review from the queue.
        if (determination){
            deleteReview(review);
        }
        else {
            review.getFlagged().UnflagReview();
        }

    }

    public void deleteReview(FlaggedReview review){
        //Deletes review from everywhere except the archive.
        review.getFlagged().getDishReviewed().removeReview(review.getFlagged());
        review.getFlagger().removeReview(review.getFlagged());

        List<> queue = accessData("FlaggedReviewQueue.ser");
        queue.remove(review);
        storeData("FlaggedReviewQueue.ser", queue);


    }
    public void archiveFlaggedReview(FlaggedReview review){
        //Adds flagged review to archive of previously flagged reviews.
        List<> queue = accessData("FlaggedReviewArchive.ser");
        queue.add(review);
        storeData("FlaggedReviewArchive.ser", queue);
    }
}
