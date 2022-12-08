package APP_Business_Rules.MenuUseCase;

import APP_Business_Rules.DishMenu.DishDataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuInteractor implements MenuInputBoundary {
    private DishDataAccess dataAccess;
    private MenuOutputBoundary outputBoundary;

    public MenuInteractor(DishDataAccess dataAccess, MenuOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void generateMenu(MenuRequestModel menuRequestModel) {
        HashMap<String, List<List<String>>> data = dataAccess.getDish("src/main/java/Frameworks_and_Drivers/Dishes.csv");
        List<List<String>> formattedData = new ArrayList<>();
        if (data.containsKey(menuRequestModel.getRestaurantName())) {
            formattedData = new ArrayList<>(dataAccess.getDish("src/main/java/Frameworks_and_Drivers/Dishes.csv").get(menuRequestModel.getRestaurantName()));
        }
        outputBoundary.update(new MenuResponseModel(formattedData));
    }
}
