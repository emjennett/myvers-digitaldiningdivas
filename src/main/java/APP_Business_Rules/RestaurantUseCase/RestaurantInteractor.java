package APP_Business_Rules.RestaurantUseCase;

import Interface_and_Adapters.RestaurantUploadPresenter;

public class RestaurantInteractor implements RestaurantInputBoundary{
    final RestaurantUploadPresenter restaurantPresenter;
    public RestaurantInteractor(RestaurantUploadPresenter restaurantPresenter){
        this.restaurantPresenter = restaurantPresenter;
    }
    @Override
    public RestaurantResponseModel create(RestaurantRequestModel requestModel) {
        return null;
    }

}
