package APP_Business_Rules.create_user;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class CreateUserGatewayModel implements Serializable {

    private final String username;

    private final String password;

    private final String type;
    private final LocalDate date;
    private String img;
    private List<String> favRestaurants;

    private static final long serialVersionUID = 6699369025684807396L;

    /**
     * The model representation to be stored for a created user
     *
     * @param username chosen username.
     * @param password chosen password.
     */
    CreateUserGatewayModel(String username, String password, String type, LocalDate date, String img, List<String> favRestaurants) {

        this.username = username;
        this.password = password;
        this.type = type;
        this.date = date;
        this.img = img;
        this.favRestaurants = favRestaurants;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }
    public String getImg(){
        return img;
    }

    public List<String> getFavRestaurants() {
        return favRestaurants;
    }

    public String getNewRes() { return "Alo";
    }
}