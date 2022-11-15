package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

public class Restaurant implements Serializable {
    private String resCategory; //Category of the restaurant
    private String location; //Location of the restaurant
    private Double rating; //Average rating of the restaurant from its corresponding dish ratings
    private ArrayList<Dish> dishRatings = new ArrayList<Dish>();
    private Menu menu;
    public Restaurant(Menu menu, String resCategory){
        this.menu = menu;
        this.resCategory = resCategory;

    }
    public void storeMenu(Menu menu){
        //Stores menus inside this Restaurant. For example, a restaurant may have a drink menu,
        //a dessert menu, and a dinner menu.
        HashMap<String, Menu> menuMap = new HashMap<String, Menu>();
        menuMap.put(menu.getTitle(), menu);
    }

    public String getResCategory(){
        return resCategory;
    }

    public double getRating(){
        return rating;
    }

    public void restaurantRating(){
        //Evaluates average rating of restaurant from its dish ratings.
        double sum = 0;
        for (int i = 0; i < dishRatings.size(); i++) {
            sum += dishRatings.get(i).getRating();
        }
        this.rating = sum/dishRatings.size();
    }

}
