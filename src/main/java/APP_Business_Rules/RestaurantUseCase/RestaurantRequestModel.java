package APP_Business_Rules.RestaurantUseCase;

public class RestaurantRequestModel {
    private String resName;
    private String resCategory;
    public RestaurantRequestModel(String resName, String resCategory){
        this.resName = resName;
        this.resCategory = resCategory;
    }

    public String getResCategory(){
        return resCategory;
    }

    public String getResName(){
        return resName;
    }
}
