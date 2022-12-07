package APP_Business_Rules;

import Entities.Account;
import Entities.FlaggedReview;
import Entities.Review;

public interface FlagReviewInputBoundry {

    void flagged(Review review, Account flagger);

    void resolveFlag(boolean determination, FlaggedReview review);

    void deleteReview(FlaggedReview review);

    void archiveFlaggedReview(FlaggedReview review);
}
