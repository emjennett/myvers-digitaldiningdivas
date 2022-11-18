package Entities;

import java.util.ArrayList;

public class AccountUser extends Account{
    /**
     * Account meant for an average user.
     *
     * userReviews: List of reviews written by the user.
     */

    private ArrayList<Review> userReviews = new ArrayList<>();

    public AccountUser(String name, String pass) {
        super(name, pass);
    }

    public void removeReview(Review review){
        /**
         * Removes a user review from the user list of reviews
         */
        userReviews.remove(review);
    }
}
