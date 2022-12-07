package APP_Business_Rules.DisplayReviewsUseCase;

import Entities.Review;

import java.util.List;

public class DisplayReviewsResponseModel {

    private List<Review> reviews;

    public DisplayReviewsResponseModel(List<Review> reviews){

        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
