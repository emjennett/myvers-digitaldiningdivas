package APP_Business_Rules.DishMenu;

import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishFormatted;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DishInteractorTest {
    DishFactory dishFactory = new DishFactory();
    DishFileReader dishFileReader = new DishFileReader("Frameworks_and_Drivers/Dishes.csv");
    DishFormatted dishFormatted = new DishFormatted();
    DishInteractor dishInteractor = new DishInteractor(dishFileReader, dishFormatted, dishFactory);
    DishController dishController = new DishController(dishInteractor);
    @Test
    void create() {
        DishRequestModel requestModel = new DishRequestModel("Pizza", "Entree", "Don Alfonso 1890", "A pizza", 10.99);
        assert Objects.equals(dishController.create(requestModel).getDish(), requestModel.getDishName());
    }
}