package APP_Business_Rules.RestaurantUseCase;

import Entities.AccountOwner;

import java.util.List;

public class RestaurantRequestModel {
    private String resName;
    private String resCategory;
    private String resLocation;
    private int stars;
    private List<String> likeList;
    private String newLike;

    public RestaurantRequestModel(String resName, String resCategory, String resLocation, int stars, List<String> likeList, String newLike) {
        this.resName = resName;
        this.resCategory = resCategory;
        this.resLocation = resLocation;
        this.stars = stars;
        this.likeList = likeList;
        this.newLike = newLike;

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


    public String getNewLike() { return newLike;
    }

    public List<String> getLikeList() { return likeList;
    }
}