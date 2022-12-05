package APP_Business_Rules.LoadAccountInfo;

import java.io.Serializable;
import java.util.List;

public class UserAccountInfoModel implements Serializable {

    private String username;

    private String bio = "";

    private List<String> restaurants;

    private List<String> dishes;

    public UserAccountInfoModel(String username){
        this.username = username;
    }

    public String getUser(){
        return username;
    }

    public String getBio(){
        return bio;
    }
    public List<String> getRestaurants(){
        return restaurants;
    }
    public List<String> getDishes(){
        return dishes;
    }

    public void changeBio(String newbio){
        this.bio = newbio;
    }

}




