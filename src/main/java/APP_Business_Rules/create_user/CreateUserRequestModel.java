package APP_Business_Rules.create_user;

public class CreateUserRequestModel {

    private String username;

    private String password;

    private String dup_password;

    /**
     * The model that will take the necessary information to create a user.
     * @param username chosen from input.
     * @param password chosen from input.
     * @param dup_password chosen from input.
     */
    public CreateUserRequestModel(String username, String password, String dup_password){

        this.username = username.strip() ;
        this.password = password;
        this.dup_password = dup_password;
    }

    public String getUsername(){return this.username;}

    public String getPassword(){return this.password;}

    public String getDup_password(){return this.dup_password;}

    public boolean validPassword() {
        return password.length() >= 6;
    }
}
