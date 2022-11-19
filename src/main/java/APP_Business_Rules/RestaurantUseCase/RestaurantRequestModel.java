package APP_Business_Rules.RestaurantUseCase;

public class RestaurantRequestModel {
    private String nameOfRes;
    private String resCategory;
    private String location;
    public RestaurantRequestModel(String nameOfRes, String resCategory, String location){
        this.nameOfRes = nameOfRes;
        this.resCategory = resCategory;
        this.location = location;

    }

}
