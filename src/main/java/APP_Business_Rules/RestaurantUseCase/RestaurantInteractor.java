package APP_Business_Rules.RestaurantUseCase;

import APP_Business_Rules.login_user.LoginUserGatewayModel;
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
        Restaurant restaurant = restaurantFactory.create(requestModel.getResName(), requestModel.getResCategory(),
                requestModel.getResLocation(), requestModel.getStars());
        RestaurantGatewayModel gatewayModel= new RestaurantGatewayModel(restaurant.getName(), restaurant.getResCategory(),
                restaurant.getLocation(), restaurant.getStars());
        gateway.loadRestaurant(gatewayModel);
        RestaurantResponseModel restaurantResponseModel = new RestaurantResponseModel(gateway.loadRestaurant(gatewayModel));
        return restaurantPresenter.prepareSuccessView(restaurantResponseModel);
    }

}
