package APP_Business_Rules.DishMenu;

public class DishResponseModel {
    String dish;
    public DishResponseModel(String dish){
        this.dish = dish;
    }

    public String getDish(){
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }
}
