package Interface_and_Adapters.DishMenuScreens;


import APP_Business_Rules.DishMenu.DishInputBoundary;
import APP_Business_Rules.DishMenu.DishRequestModel;
import APP_Business_Rules.DishMenu.DishResponseModel;

public class DishController {
    /* Retrieves user Input from Dish View and passes it to the Interactor to modify Dish
    private final DishInputBoundary
     */
    private final DishInputBoundary userInput;
    public DishController(DishInputBoundary dishGateway){
        this.userInput = dishGateway;
    }
    DishResponseModel create(DishRequestModel requestModel){
        return userInput.create(requestModel);
    }
}