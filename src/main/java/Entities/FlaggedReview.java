package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlaggedReview implements Serializable {
    //A class meant primarily for the storage of a flagged review for the purpose of later review by administrator
    // and eventual archiving.
    private Review flagged; //The review which needs addressing.
    private Account flagger; //Account which flagged the review for review.

    private Date createdOn; //Date which the review was flagged.

    public FlaggedReview(Review review, Account flagger){
        //Constructor for the flagged review class .
        this.flagged = review;
        this.flagger = flagger;
        this.createdOn = new Date();
    }

    public Review getFlagged() {
        return flagged;
    }

    public Account getFlagger() {
        return flagger;
    }

    public String getCreatedOn() {
        //Returns the date the review was flagged in string form.
        SimpleDateFormat formatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatted.format(this.createdOn);
    }
}
