package APP_Business_Rules.RestaurantUseCase;

public interface RestaurantInputBoundary {

    RestaurantResponseModel updateRestaurant(RestaurantRequestModel restaurantRequestModel);

    RestaurantResponseModel removeFav(RestaurantRequestModel restaurantRequestModel);
}
