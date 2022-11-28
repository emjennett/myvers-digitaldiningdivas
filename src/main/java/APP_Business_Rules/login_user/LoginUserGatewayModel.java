package APP_Business_Rules.login_user;

import java.io.Serializable;

public class LoginUserGatewayModel implements Serializable {

    private final String username;

    LoginUserGatewayModel(String username){

        this.username = username;

    }

    public String getUsername() {return username;}
}
