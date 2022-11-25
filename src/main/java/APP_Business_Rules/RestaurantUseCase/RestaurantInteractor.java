package APP_Business_Rules.RestaurantUseCase;

import Entities.Restaurant;
import Interface_and_Adapters.RestaurantPresenter;

public class RestaurantInteractor implements RestaurantInputBoundary{
    final RestaurantPresenter restaurantPresenter;
    final RestaurantFactory restaurantFactory;
    final RestaurantDataAccess gateway;

    public RestaurantInteractor(RestaurantDataAccess gateway, RestaurantPresenter restaurantPresenter, RestaurantFactory restaurantFactory
    ){
        this.restaurantPresenter = restaurantPresenter;
        this.restaurantFactory = restaurantFactory;
        this.gateway = gateway;
    }
    @Override
    public RestaurantResponseModel create(RestaurantRequestModel requestModel) {
        Restaurant restaurant = restaurantFactory.create(requestModel.getResName(), requestModel.getResCategory());
        RestaurantResponseModel restaurantResponseModel = new RestaurantResponseModel(restaurant.getName());
        return restaurantPresenter.prepareSuccessView(restaurantResponseModel);
    }

}
