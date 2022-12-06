package Interface_and_Adapters.restaurant_screens;


import Entities.Restaurant;

import java.util.HashMap;
import APP_Business_Rules.RestaurantUseCase.RestaurantResponseModel;
public interface RestaurantPresenter {
    /*
    Passes proper restaurant model over to the interactor
     */
    public RestaurantResponseModel prepareSuccessView(RestaurantResponseModel responseModel);
}