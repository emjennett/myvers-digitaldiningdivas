package APP_Business_Rules.DishMenu;

public class DishDsRequestModel {
    private final String name;


    DishDsRequestModel(String name, String resCategory, String menuTitle, String menuDesc){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}