package Interface_and_Adapters;

import APP_Business_Rules.DishMenu.DishDataAccess;
import APP_Business_Rules.MenuUseCase.MenuInputBoundary;
import APP_Business_Rules.MenuUseCase.MenuRequestModel;

public class MenuController {
    private MenuInputBoundary menuInputBoundary;

    public MenuController(MenuInputBoundary menuInputBoundary) {
        this.menuInputBoundary = menuInputBoundary;
    }

    public void generateMenu(String restaurantName){
        menuInputBoundary.generateMenu(new MenuRequestModel(restaurantName));
    }
}
