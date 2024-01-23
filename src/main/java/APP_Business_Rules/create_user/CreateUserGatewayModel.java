package APP_Business_Rules.create_user;

import java.io.Serializable;
import java.time.LocalDate;

public class CreateUserGatewayModel implements Serializable {

    private final String username;

    private final String password;

    private final String type;
    private final LocalDate date;

    private static final long serialVersionUID = 6699369025684807396L;

    /**
     * The model representation to be stored for a created user
     * @param username chosen username.
     * @param password chosen password.
     */
    CreateUserGatewayModel(String username, String password, String type, LocalDate date){

        this.username = username;
        this.password = password;
        this.type = type;
        this.date = date;

    }
    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public String getType() {return type;}

    public LocalDate getDate() {return date;
    }
}
