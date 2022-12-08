package APP_Business_Rules.create_user;

import java.io.Serializable;

public class CreateUserGatewayModel implements Serializable {

    private final String username;

    private final String password;

    /**
     * The model representation to be stored for a created user
     * @param username chosen username.
     * @param password chosen password.
     */
    CreateUserGatewayModel(String username, String password){

        this.username = username;
        this.password = password;
    }
    public String getUsername() {return username;}

    public String getPassword() {return password;}
}
