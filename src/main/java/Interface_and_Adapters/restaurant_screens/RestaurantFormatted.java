package Interface_and_Adapters.restaurant_screens;

import APP_Business_Rules.RestaurantUseCase.RestaurantResponseModel;

public class RestaurantFormatted implements RestaurantPresenter {
    @Override
    public RestaurantResponseModel prepareSuccessView(RestaurantResponseModel response){
        return response;
    }
}