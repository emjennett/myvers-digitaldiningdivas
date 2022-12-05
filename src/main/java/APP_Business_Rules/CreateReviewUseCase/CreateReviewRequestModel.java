package APP_Business_Rules.CreateReviewUseCase;

import Entities.AccountUser;

public class CreateReviewRequestModel {

    private AccountUser user;

    private Object reviewed;

    private String review;

    private Integer rating;

    public CreateReviewRequestModel(AccountUser user, Object reviewed, String review, Integer rating){
         this.user = user;
         this.reviewed = reviewed;
         this.review = review;
         this.rating = rating;
    }

    public AccountUser getUser() {
        return user;
    }

    public Object getReviewed() {
        return reviewed;
    }

    public String getReview() {
        return review;
    }

    public Integer getRating() {
        return rating;
    }
}
