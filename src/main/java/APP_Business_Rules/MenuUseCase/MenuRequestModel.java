package APP_Business_Rules.MenuUseCase;

public class MenuRequestModel {
    private String restaurantName;

    public MenuRequestModel(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}
