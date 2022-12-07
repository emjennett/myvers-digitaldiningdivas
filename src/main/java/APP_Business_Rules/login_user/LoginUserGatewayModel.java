package APP_Business_Rules.login_user;

import java.io.Serializable;

public class LoginUserGatewayModel implements Serializable {

    private final String username;

    private final String type;

    private static final long serialVersionUID = 62817323539602193L;


    /**
     * The model stored and withdrawn for a user if the password matches the account.
     * @param username the user who logged in.
     */
    LoginUserGatewayModel(String username, String type){

        this.username = username;
        this.type = type;

    }

    public String getUsername() {return username;}


    public String getType() { return type;
    }
}
