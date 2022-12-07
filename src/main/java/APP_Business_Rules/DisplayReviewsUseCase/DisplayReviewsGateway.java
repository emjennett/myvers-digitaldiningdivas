package APP_Business_Rules.DisplayReviewsUseCase;

import Entities.Review;

import java.util.List;

public interface DisplayReviewsGateway {

    List<Review> retrieveReviews(String dishOrRestaurant);
}
