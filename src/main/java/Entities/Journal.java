package Entities;

import APP_Business_Rules.UserDataGrabber;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

public class Journal {
    private String name; // Name of Journal Owner

    private Account userAccount; // account of Journal Owner

    private List<Review> reviews = new ArrayList<>(); // List of reviews of dish

    private Date createdOn; // Date that the Journal was created on.



    public Journal(String name, Account Account){
        this.name = name;
        this.userAccount = Account;
        this.createdOn = new Date();

    }

    public String pullName(String name) {
        return this.name;

    }

    public Account pullAccount(String name) {
            return this.userAccount;
        }

    public String getCreatedOn() {
        //Returns the date which the Journal was created on in string form.
        SimpleDateFormat formatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatted.format(this.createdOn);

    }
    public List<Review> pullInformation(){
        // returns all of the reviews corresponding to account
        // this is a work in progress as user data grabber is nodefined yet
        // I'm assuming that user data grabber returns a arraylist of reviews

        List<Review> allreviews = UserDataGrabber(this.userAccount);
        return allreviews;
    }









}
