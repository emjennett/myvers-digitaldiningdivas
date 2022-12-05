package APP_Business_Rules.DisplayReviewsUseCase;

import Entities.Review;

import java.util.List;

public interface LoadReviewsGateway {

    List<Review> retrieveReviews(Object dishOrRestaurant);
}
