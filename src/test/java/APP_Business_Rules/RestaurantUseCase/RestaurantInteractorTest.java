package APP_Business_Rules.RestaurantUseCase;

import Interface_and_Adapters.restaurant_screens.RestaurantController;
import Interface_and_Adapters.restaurant_screens.RestaurantFormatted;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantInteractorTest {

    @Test
    void create() {
        RestaurantFileReader restaurantFileReader = new RestaurantFileReader("Restaurant.csv");
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        RestaurantFormatted restaurantFormatted = new RestaurantFormatted();
        RestaurantInteractor restaurantInteractor = new RestaurantInteractor(restaurantFileReader, restaurantFormatted, restaurantFactory);
        RestaurantController restaurantController = new RestaurantController(restaurantInteractor);
        RestaurantResponseModel responseModel = restaurantController.create(new RestaurantRequestModel("Chef Said", "Middle Eastern", "Residence Nadia", 1));

        assert responseModel.getRestaurantName().equals("Chef Said");
        assert responseModel.getCategory().equals("Middle Eastern");
        assert responseModel.getLocation().equals("Residence Nadia");
        assert responseModel.getStars() == 1;

    }
}