package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.util.List;

public class Restaurant extends ReviewableObject implements Serializable {

    /**
     * A class that represents a specific restaurant.
     *
     * resCategory: Category of the restaurant
     * location: Location of the restaurant
     * rating: Average rating of the restaurant from its corresponding dish ratings
     * dishRatings:
     * menu: The restaurant menu.
     */
    private String resCategory;

    private Menu menu = null;
    private String name;
    private String location;
    private int stars;
    private Double rating;
    private ArrayList<Dish> dishRatings = new ArrayList<Dish>();
    private List<String> likeList;
    private String newLike;
    private static final long serialVersionUID = 8843875683983141039L;
    public Restaurant(String name, String resCategory, String location, int stars, List<String> likeList, String newLike){
        this.resCategory = resCategory;
        this.name = name;
        this.location = location;
        this.stars = stars;
        this.likeList = likeList;
        this.newLike = newLike;

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


    public int getStars(){
        return stars;
    }

    public String getName(){
        return name;
    }

    public String getLocation() {return location;}

    public void restaurantRating(){
        //Evaluates average rating of restaurant from its dish ratings.
        double sum = 0;
        for (int i = 0; i < dishRatings.size(); i++) {
            sum += dishRatings.get(i).getRating();
        }
        this.rating = sum/dishRatings.size();
    }

    public String getNewLike() {
        return newLike;
    }

    public List<String> getLikeList() { return likeList;
    }

}
