package APP_Business_Rules.DisplayReviewsUseCase;

import Entities.ReviewableObject;

public class DisplayReviewsRequestModel {

    private String reviewed;

    public DisplayReviewsRequestModel(String reviewed){
        this.reviewed = reviewed;
    }

    public String getReviewed() {
        return reviewed;
    }
}
