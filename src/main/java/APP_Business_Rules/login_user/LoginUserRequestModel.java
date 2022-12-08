package APP_Business_Rules.login_user;

public class LoginUserRequestModel {

    private String username;

    private String password;
    private String type;

    /**
     * The model needed from the user input to attempt a login.
     * @param username chosen account to access.
     * @param password chosen password to access the account.
     */

    public LoginUserRequestModel(String username, String password){

        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getUsername(){return this.username;}

    public String getPassword(){return this.password;}

}
