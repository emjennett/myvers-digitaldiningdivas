package APP_Business_Rules.login_user;

import java.io.Serializable;
import java.time.LocalDate;

public class LoginUserGatewayModel implements Serializable {

    private final String username;

    private final String type;
    private String bio;
    private String pic;
    private LocalDate date;

    private static final long serialVersionUID = 62817323539602193L;


    /**
     * The model stored and withdrawn for a user if the password matches the account.
     * @param username the user who logged in.
     */
    public LoginUserGatewayModel(String username, String type, LocalDate date){

        this.username = username;
        this.type = type;
        this.date = date;


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
}
