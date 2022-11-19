package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Review implements Serializable {
    //*A review of a restaurant or dish
    private boolean flagged = false; //Variable which shows if the review has been flagged for review.
    private String review; //The string which contains the review.
    private AccountUser author; //The user account which posted the review.
    private Date createdOn; //Date of the reviews' creation.
    private int upVotes = 0; //Number of up votes given to the review.
    private int rating; //User given rating.
    private Dish dishReviewed; //The dish reviewed.

    public Review(AccountUser author, String review, Dish dish, int rating){
        //The constructor for the review class
        this.author = author;
        this.review = review;
        this.createdOn = new Date();
        this.rating = rating;
        this.dishReviewed = dish;
    }

    public String getAuthor(){
        //Returns the authors' username.
        return this.author.getUserName();
    }

    public int getRating() {
        //returns the review rating.
        return rating;
    }

    public String getReview() {
        return review;
    }

    public void flagReview(){
        //Marks the review as flagged for further review.
        this.flagged = true;
    }
    public void UnflagReview(){
        //Unflags the review and returns it to a normal status.
        this.flagged = false;
    }

    public String getCreatedOn() {
        //Returns the date which the review was created on in string form.
        SimpleDateFormat formatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatted.format(this.createdOn);
    }

    public void setReview(String newReview){
        //A setter for the review variable used for editing of a review.
        this.review = newReview;
    }

    public void addVote(){
        //Adds a vote to upVotes.
        this.upVotes += 1;
    }
}
