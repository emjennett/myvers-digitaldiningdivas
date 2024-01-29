package APP_Business_Rules.RestaurantUseCase;

public class RestaurantResponseModel {
    RestaurantGatewayModel model;

    private int likes;

    public RestaurantResponseModel(RestaurantGatewayModel model) {
        this.model = model;
    }

    public String getRestaurantName() {
        return this.model.getResName();
    }

    public String getCategory() {
        return this.model.getResCategory();
    }

    public String getLocation() {
        return this.model.getResLocation();
    }

    public int getStars() {
        return this.model.getStars();
    }

    public int getLikes(){
        return this.model.getLikes();
    }

    public void setLikes(int newLikes) {
        this.likes = newLikes;
    }
}
