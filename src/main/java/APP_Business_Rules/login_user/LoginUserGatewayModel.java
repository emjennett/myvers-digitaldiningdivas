package APP_Business_Rules.login_user;

import java.io.Serializable;

public class LoginUserGatewayModel implements Serializable {

    private final String username;

    /**
     * The model stored and withdrawn for a user if the password matches the account.
     * @param username the user who logged in.
     */
    LoginUserGatewayModel(String username){

        this.username = username;

    }

    public String getUsername() {return username;}


}
