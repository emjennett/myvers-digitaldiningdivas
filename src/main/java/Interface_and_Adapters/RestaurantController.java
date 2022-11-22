package Interface_and_Adapters;

import APP_Business_Rules.RestaurantUseCase.RestaurantInputBoundary;
import APP_Business_Rules.RestaurantUseCase.RestaurantRequestModel;
import APP_Business_Rules.RestaurantUseCase.RestaurantResponseModel;

public class RestaurantController {
    /* Retrieves user Input from Restaurant View and passes it to the Interactor to modify Restaurant
    private final RestaurantInputBoundary
     */
    private final RestaurantInputBoundary userInput;
    public RestaurantController(RestaurantInputBoundary restaurantGateway){
        this.userInput = restaurantGateway;
    }
    RestaurantResponseModel create(RestaurantRequestModel requestModel){
        return userInput.create(requestModel);
    }
}
