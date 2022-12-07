package APP_Business_Rules.CreateReviewUseCase;

import Entities.Review;
import Entities.ReviewableObject;

public interface CreateReviewGateway {

    void save(String dishOrRestaurant, Review review);
}
