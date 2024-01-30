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
    public RestaurantResponseModel updateRestaurant(RestaurantRequestModel requestModel) {
        Restaurant restaurant = restaurantFactory.create(requestModel.getResName(),  requestModel.getResCategory(),
                requestModel.getResLocation(), requestModel.getStars(), requestModel.getLikeList(), requestModel.getNewLike());
        RestaurantGatewayModel gatewayModel= new RestaurantGatewayModel(restaurant.getName(), restaurant.getResCategory(),
                restaurant.getLocation(), restaurant.getStars(), restaurant.getLikeList(), restaurant.getNewLike());

        RestaurantGatewayModel saved = gateway.save(gatewayModel);
        RestaurantResponseModel restaurantResponseModel = new RestaurantResponseModel(saved);
        restaurantResponseModel.setNewLike(requestModel.getNewLike());
        restaurantResponseModel.setLikeList(requestModel.getLikeList());
        return restaurantPresenter.prepareSuccessView(restaurantResponseModel);
    }

    @Override
    public RestaurantResponseModel removeFav(RestaurantRequestModel requestModel) {
        Restaurant restaurant = restaurantFactory.create(requestModel.getResName(),  requestModel.getResCategory(),
                requestModel.getResLocation(), requestModel.getStars(), requestModel.getLikeList(), requestModel.getNewLike());
        RestaurantGatewayModel gatewayModel= new RestaurantGatewayModel(restaurant.getName(), restaurant.getResCategory(),
                restaurant.getLocation(), restaurant.getStars(), restaurant.getLikeList(), restaurant.getNewLike());

        RestaurantGatewayModel saved = gateway.save(gatewayModel);
        RestaurantResponseModel restaurantResponseModel = new RestaurantResponseModel(saved);
        restaurantResponseModel.setNewLike(requestModel.getNewLike());
        restaurantResponseModel.removeFav(requestModel.getLikeList());
        return restaurantPresenter.prepareSuccessView(restaurantResponseModel);
    }

}
