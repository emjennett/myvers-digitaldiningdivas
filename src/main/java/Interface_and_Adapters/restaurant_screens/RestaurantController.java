package Interface_and_Adapters.restaurant_screens;

import APP_Business_Rules.RestaurantUseCase.RestaurantInputBoundary;
import APP_Business_Rules.RestaurantUseCase.RestaurantRequestModel;
import APP_Business_Rules.RestaurantUseCase.RestaurantResponseModel;

public class RestaurantController {
    /* Retrieves user Input from Restaurant View and passes it to the Interactor to modify Restaurant
    private final RestaurantInputBoundary
     */
    final RestaurantInputBoundary userInput;
    public RestaurantController(RestaurantInputBoundary restaurantGateway){
        this.userInput = restaurantGateway;
    }
    public RestaurantResponseModel create(String resTitle, String resCategory, String location, int stars){
        RestaurantRequestModel restaurantRequestModel = new
                RestaurantRequestModel(resTitle, resCategory, location, stars);
        return userInput.create(restaurantRequestModel);
    }
}
