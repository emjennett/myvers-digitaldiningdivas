package Entities;

import java.io.Serializable;
import java.util.HashMap;

public class Menu implements Serializable {
    private Dish dish;
    //A class that holds and organizes dish information
    private String title;
    private String description;


    public Menu(Dish dish, String title, String description){
        this.dish = dish;
        this.title = title;
        this.description = description;

    }
    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public void storeDishes(Dish dish){
        //Stores dishes in a hashmap. This can be used in cases of dish searching from the user.
        HashMap<String, Dish> dishMap = new HashMap<String, Dish>();
        dishMap.put(dish.getName(), dish);
    }

}
