package APP_Business_Rules.CreateReviewUseCase;

import Entities.Review;

public interface CreateReviewGateway {

    void save(Object dishOrRestaurant, Review review);
}
