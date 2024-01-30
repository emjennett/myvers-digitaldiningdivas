package APP_Business_Rules.login_user;

import java.time.LocalDate;
import java.util.List;

public class LoginUserResponseModel {

    LoginUserGatewayModel model;
    private String bio;
    private LocalDate date;
    private String pic;
    private List<String> favRestaurants;
    private String newRes;

    /**
     * The result for when a user has attempted a login.
     * @param model the information found from a login.
     */
    public LoginUserResponseModel(LoginUserGatewayModel model) {
        this.model = model;
    }

    public String getUsername(){
        return this.model.getUsername();
    }
    public String getType(){
        return this.model.getType();
    }


    public String getBio() {return this.model.getBio();
    }

    public void setBio(String newBio) {
        this.bio = newBio;
    }

    public LocalDate getDate() {
        return this.model.getDate();
    }

    public void setDate(LocalDate newDate) { this.date = newDate;
    }

    public void setPic(String newPic) { this.pic = newPic;
    }

    public String getPic() { return this.model.getPic();
    }


    public List<String> getFavRestaurants() { return this.model.getFavRestaurants();
    }

    public void setFavRestaurants(List<String> list) {
        if(getNewRes()!=null) {
            list.add(getNewRes());
            this.favRestaurants = list;
        }
    }

    public String getNewRes() {return this.model.getNewRes();

    }

    public void setNewRes(String rezzy) {
        this.newRes = rezzy;
    }

}
