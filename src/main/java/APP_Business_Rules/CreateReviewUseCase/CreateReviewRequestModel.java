package APP_Business_Rules.CreateReviewUseCase;

import Entities.AccountUser;
import Entities.ReviewableObject;

public class CreateReviewRequestModel {

    private String user;

    private String reviewed;

    private String review;

    private Integer rating;

    public CreateReviewRequestModel(String user, String reviewed, String review, Integer rating){
         this.user = user;
         this.reviewed = reviewed;
         this.review = review;
         this.rating = rating;
    }

    public String getUser() {
        return user;
    }

    public String getReviewed() {
        return reviewed;
    }

    public String getReview() {
        return review;
    }

    public Integer getRating() {
        return rating;
    }
}
