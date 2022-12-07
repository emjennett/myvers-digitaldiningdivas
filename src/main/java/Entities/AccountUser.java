package Entities;
import java.util.ArrayList;
import java.util.Objects;

public class AccountUser extends Account implements Comparable<AccountUser>, User, Loggable{
    /**
     * Account meant for an average user.
     *
     * userReviews: List of reviews written by the user.
     */

    private ArrayList<Review> userReviews;
    private int score;


    public AccountUser(String name, String pass) {
        super(name, pass);
        this.score = 0;
        this.userReviews = new ArrayList<>();
    }

    
    public void removeReview(Review review){
        /**
         * Removes a user review from the user list of reviews
         */
        userReviews.remove(review);
    }

    public int getScore(){
        return this.score;
    }

    public ArrayList<Review> getUserReviews() {
        return userReviews;
    }

    @Override
    public String getType(){
        return "user";
    }

    @Override
    public int compareTo(AccountUser o) {
        if (this.getScore() < o.getScore()){
            return -1;
        } else if (this.getScore() > o.getScore()) {
            return 1;
        }
        else {
            return 0;
        }
    }
    /**
     * A method to check if a password achieves the required security measure
     * return true otherwise false.
     */
    @Override
    public boolean validPassword() {
        return this.getPassword().length() >= 6;
    }
}
