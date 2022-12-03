package APP_Business_Rules.RestaurantUseCase;

public class RestaurantRequestModel {
    private String resName;
    private String resCategory;
    private String resLocation;
    private int stars;
    public RestaurantRequestModel(String resName, String resCategory, String resLocation, int stars){
        this.resName = resName;
        this.resCategory = resCategory;
        this.resLocation = resLocation;
        this.stars = stars;
    }

    public String getResCategory(){
        return resCategory;
    }

    public String getResName(){
        return resName;
    }

    public String getResLocation() {
        return resLocation;
    }

    public int getStars() {
        return stars;
    }
}
