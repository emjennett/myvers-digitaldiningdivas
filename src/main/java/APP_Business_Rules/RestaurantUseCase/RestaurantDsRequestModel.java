package APP_Business_Rules.RestaurantUseCase;

import Entities.Menu;

public class RestaurantDsRequestModel {
    private final String name;
    private final String resCategory;
    private final String menuTitle;
    private final String menuDesc;


    RestaurantDsRequestModel(String name, String resCategory, String menuTitle, String menuDesc){
        this.name = name;
        this.resCategory = resCategory;
        this.menuDesc = menuDesc;
        this.menuTitle = menuTitle;
    }
    public String getName(){
        return name;
    }
    public String getResCategory(){
        return resCategory;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public String getMenuDesc() {
        return menuDesc;
    }


}
