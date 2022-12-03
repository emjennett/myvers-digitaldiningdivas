package APP_Business_Rules.DishMenu;

public class DishRequestModel {
    private String DishName;
    private String DishCategory;
    private String restaurant;
    private String description;
    private double price;

    public DishRequestModel(String DishName, String DishCategory, String Restaurant, String Description, double price){
        this.DishName = DishName;
        this.DishCategory = DishCategory;
        this.restaurant = Restaurant;
        this.description = Description;
        this.price = price;

    }

    public String getDishCategory(){
        return DishCategory;
    }

    public String getDishName(){
        return DishName;
    }

    public String getRestaurant(){
        return restaurant;
    }

    public String getDescription(){
        return description;
    }

    public double getPrice(){
        return price;
    }
}
