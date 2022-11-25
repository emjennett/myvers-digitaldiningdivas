package APP_Business_Rules.RestaurantUseCase;

import Interface_and_Adapters.RestaurantPresenter;

public class RestaurantResponseModel{
    String restaurant;
    public RestaurantResponseModel(String restaurant){
        this.restaurant = restaurant;
    }

    public String getRestaurant(){
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}
