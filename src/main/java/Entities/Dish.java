package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dish implements Serializable {
    /**
     * A class that holds all the information for a particular dish at a restaurant.
     *
     * name: Name of the dish.
     * category: The category of the dish.
     * reviews: List of reviews of the dish.
     * rating: Average rating of the dish.
     * createdOn: Date dish object was created.
     */

    private String name;
    private String category;
    private ArrayList<Review> reviews = new ArrayList<>();
    private Double rating;
    private Date createdOn;

    public Dish(String name, String category){
        /**
         * Constructor for the dish class.
         */
        this.name = name;
        this.category = category;
        this.createdOn = new Date();
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        /**
         * returns name of dish.
         */
        return name;
    }

    public String getCategory() {
        /**
         * Returns category of the dish.
         */
        return category;
    }

    public Double getRating(){
        /**
         * Returns the dishes average rating.
         */
        return rating;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public String getCreatedOn() {
        /**
         * Returns date of creation in string form.
         */
        SimpleDateFormat formatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatted.format(this.createdOn);
    }

    public void addReview(Review review){
        /**
         * Adds a new review of the dish.
         */
        this.reviews.add(review);
        newAverage();
    }

    public void newAverage(){
        /**
         * sets a new average rating.
         */
        double total = 0;
        for (int i = 0; i < reviews.size(); i++){
            total += reviews.get(i).getRating();
        }
        this.rating = total/reviews.size();
    }

    public void removeReview(Review review){
        /**
         * Removes a review from the list of reviews of this dish.
         */
        reviews.remove(review);
    }
}
