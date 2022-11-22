package Entities;
import java.util.ArrayList;

public class AccountUser extends Account implements Comparable<AccountUser>{
    /**
     * Account meant for an average user.
     *
     * userReviews: List of reviews written by the user.
     */

    private ArrayList<Review> userReviews = new ArrayList<>();
    private int score;

    public AccountUser(String name, String pass) {
        super(name, pass);
        this.score = 0;
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
}
