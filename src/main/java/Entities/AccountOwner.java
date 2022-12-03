package Entities;

import java.util.ArrayList;

public class AccountOwner extends Account implements User, Loggable{
    private final ArrayList<Review> userReviews;

    public AccountOwner(String name, String pass) {
        super(name, pass);
        this.userReviews = new ArrayList<>();
    }
    @Override
    public boolean validPassword() {
        return this.getPassword().length() >= 6;
    }
}