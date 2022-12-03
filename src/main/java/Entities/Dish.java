package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dish implements Serializable {
    //A class that holds all the information for a particular dish at a restaurant.

    private String name; //Name of the dish.
    private String category; //The category of the dish.
    private String restaurant; //The restaurant the dish belongs to
    private String description; //The description of the dish.
    private double price; //The price of the dish


    private ArrayList<Review> reviews = new ArrayList<>(); //List of reviews of the dish.
    private Double rating; //average rating of the dish.
    private Date createdOn; //Date dish object was created.


    public Dish(String name, String category, String restaurant, String description, double price){
        this.name = name;
        this.category = category;
        this.restaurant = restaurant;
        this.description = description;
        this.price = price;
        this.createdOn = new Date();
    }

    public String getName() {
        //returns name of dish.
        return name;
    }

    public String getCategory() {
        //Returns category of the dish.
        return category;
    }

    public String getRestaurant(){
        //Returns the restaurant the dish belongs to
        return restaurant;
    }

    public Double getRating(){
        return rating;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public String getCreatedOn() {
        //returns date of creation in string form
        SimpleDateFormat formatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatted.format(this.createdOn);
    }

    public void addReview(Review review){
        //Adds a new review of the dish.
        this.reviews.add(review);
        newAverage();
    }

    public void newAverage(){
        //sets a new average rating
        double total = 0;
        for (int i = 0; i < reviews.size(); i++){
            total += reviews.get(i).getRating();
        }
        this.rating = total/reviews.size();
    }
}