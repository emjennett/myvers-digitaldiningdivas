package APP_Business_Rules.login_user;

import Entities.Restaurant;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class LoginUserGatewayModel implements Serializable {

    private final String username;

    private final String type;
    private String bio;
    private String pic;
    private LocalDate date;

    private static final long serialVersionUID = 62817323539602193L;
    private List<String> favRestaurants;
    private String newRes;


    /**
     * The model stored and withdrawn for a user if the password matches the account.
     * @param username the user who logged in.
     */
    public LoginUserGatewayModel(String username, String type, LocalDate date, String pic, List<String> favRestaurants, String newRes){

        this.username = username;
        this.type = type;
        this.date = date;
        this.pic= pic;
        this.favRestaurants = favRestaurants;
        this.newRes = newRes;


    }

    public String getUsername() {return username;}


    public String getType() { return type;
    }


    public String getBio(){return this.bio;}
    public void setBio(String newBio){
        this.bio = newBio;
    }

    public String getPic(){return this.pic;}
    public void setPic(String newPic){
        this.pic = newPic;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<String> getFavRestaurants() { return this.favRestaurants;
    }

    public String getNewRes() {
        return this.newRes;
    }

    public void setNewRes(String rezzy) { this.newRes = rezzy;
    }

    public void setFavRestaurants(List<String> list) {
        list.add(getNewRes());
        this.favRestaurants = list;
    }

    public void removeFavRestaurant(List<String> favRestaurants) {
        favRestaurants.remove(getNewRes());
        this.favRestaurants = favRestaurants;
    }
}
