package Interface_and_Adapters;


import Entities.Restaurant;

import java.util.HashMap;
import APP_Business_Rules.RestaurantUseCase.RestaurantResponseModel;
public interface RestaurantPresenter {
    RestaurantResponseModel prepareSuccessView(RestaurantResponseModel restaurantResponseModel);

}
