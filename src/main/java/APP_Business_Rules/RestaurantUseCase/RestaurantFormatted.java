package APP_Business_Rules.RestaurantUseCase;

import Interface_and_Adapters.RestaurantPresenter;

public class RestaurantFormatted implements RestaurantPresenter {
    @Override
    public RestaurantResponseModel prepareSuccessView(RestaurantResponseModel response){
        return response;
    }
}
