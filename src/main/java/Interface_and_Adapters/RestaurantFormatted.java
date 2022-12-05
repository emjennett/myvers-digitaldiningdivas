package Interface_and_Adapters;

import APP_Business_Rules.RestaurantUseCase.RestaurantResponseModel;
import Interface_and_Adapters.RestaurantPresenter;

public class RestaurantFormatted implements RestaurantPresenter {
    @Override
    public RestaurantResponseModel prepareSuccessView(RestaurantResponseModel response){
        return response;
    }
}