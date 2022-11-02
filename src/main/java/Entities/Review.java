package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Review{
    //*A review of a restaurant or dish
    protected boolean flagged = false; //Variable which shows if the review has been flagged for review.
    protected String review; //The string which contains the review.
    protected AccountUser author; //The user account which posted the review.
    protected Date createdOn; //Date of the reviews' creation.
    protected int upVotes = 0; //Number of up votes given to the review.

    public Review(AccountUser author, String review){
        //The constructor for the review class
        this.author = author;
        this.review = review;
        this.createdOn = new Date();
    }

    public String getAuthor(){
        //Returns the authors' username.
        return this.author.getUserName();
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
}
