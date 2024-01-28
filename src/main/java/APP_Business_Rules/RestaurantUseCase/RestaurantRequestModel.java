package APP_Business_Rules.RestaurantUseCase;

import Entities.AccountOwner;

public class RestaurantRequestModel {
    private String resName;
    private String resCategory;
    private String resLocation;
    private int stars;
    private int likes;

    public RestaurantRequestModel(String resName, String resCategory, String resLocation, int stars, int likes) {
        this.resName = resName;
        this.resCategory = resCategory;
        this.resLocation = resLocation;
        this.stars = stars;
        this.likes = likes;

    }

    public String getResCategory() {
        return resCategory;
    }

    public String getResName() {
        return resName;
    }

    public String getResLocation() {
        return resLocation;
    }

    public int getStars() {
        return stars;
    }

    public int getLikes(){
        return likes;
    }
}