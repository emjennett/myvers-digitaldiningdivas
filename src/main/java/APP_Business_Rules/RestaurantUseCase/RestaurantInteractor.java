package APP_Business_Rules.RestaurantUseCase;

import Entities.Restaurant;
import Interface_and_Adapters.restaurant_screens.RestaurantPresenter;

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
        Restaurant restaurant = restaurantFactory.create(requestModel.getResName(), requestModel.getResCategory(),
                requestModel.getResLocation(), requestModel.getStars());
        RestaurantGatewayModel gatewayModel= new RestaurantGatewayModel(restaurant.getName(), restaurant.getResCategory(),
                restaurant.getLocation(), restaurant.getStars());
        RestaurantGatewayModel saved = gateway.save(gatewayModel);
        RestaurantResponseModel restaurantResponseModel = new RestaurantResponseModel(saved);
        return restaurantPresenter.prepareSuccessView(restaurantResponseModel);
    }

    public Restaurant getRes(RestaurantRequestModel requestModel){
        return restaurantFactory.create(requestModel.getResName(), requestModel.getResCategory(),
                requestModel.getResLocation(), requestModel.getStars());
    }
}
