package APP_Business_Rules.RestaurantUseCase;

import Interface_and_Adapters.RestaurantPresenter;

public class RestaurantInteractor implements RestaurantInputBoundary{
    final RestaurantPresenter restaurantPresenter;
    public RestaurantInteractor(RestaurantPresenter restaurantPresenter){
        this.restaurantPresenter = restaurantPresenter;
    }
    @Override
    public RestaurantResponseModel create(RestaurantRequestModel requestModel) {
        return null;
    }

}
