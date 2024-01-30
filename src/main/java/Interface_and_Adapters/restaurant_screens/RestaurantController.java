package Interface_and_Adapters.restaurant_screens;

import APP_Business_Rules.RestaurantUseCase.RestaurantInputBoundary;
import APP_Business_Rules.RestaurantUseCase.RestaurantRequestModel;
import APP_Business_Rules.RestaurantUseCase.RestaurantResponseModel;

import java.util.ArrayList;
import java.util.List;

public class RestaurantController {
    /* Retrieves user Input from Restaurant View and passes it to the Interactor to modify Restaurant
    private final RestaurantInputBoundary
     */
    final RestaurantInputBoundary userInput;

    public RestaurantController(RestaurantInputBoundary restaurantGateway){
        this.userInput = restaurantGateway;
    }

    public RestaurantResponseModel updateRestaurant(String resTitle, String resCategory, String location, int stars, List<String> likeList, String newLike){
        RestaurantRequestModel restaurantRequestModel = new
                RestaurantRequestModel(resTitle,  resCategory, location, stars, likeList, newLike);
        return userInput.updateRestaurant(restaurantRequestModel);
    }


    public RestaurantResponseModel removeFav(String resName, String resCategory, String address, int starCount, List<String> likeList, String username) {
        RestaurantRequestModel restaurantRequestModel = new
                RestaurantRequestModel(resName,  resCategory, address, starCount, likeList, username);
        return userInput.removeFav(restaurantRequestModel);
    }
}
