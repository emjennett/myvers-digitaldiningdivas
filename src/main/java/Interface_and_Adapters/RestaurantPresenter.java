package Interface_and_Adapters;

import APP_Business_Rules.RestaurantUseCase.RestaurantResponseModel;

public interface RestaurantPresenter {
    RestaurantResponseModel RestaurantView(RestaurantResponseModel restaurant);
}
