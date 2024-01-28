package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountOwner extends Account implements User, Loggable{
    private final ArrayList<Review> userReviews;

    public AccountOwner(String name, String pass, LocalDate date, String img, List<String> favRestaurants) {
        super(name, pass, date, img, favRestaurants);
        this.userReviews = new ArrayList<>();
    }
    @Override
    public boolean validPassword() {
        return this.getPassword().length() >= 6;
    }

    @Override
    public String getType(){
        return "owner";
    }

    public void storeRestaurants(Restaurant restaurant){
        List<Restaurant> listOfRes = new ArrayList<>();
        listOfRes.add(restaurant);
    }
}