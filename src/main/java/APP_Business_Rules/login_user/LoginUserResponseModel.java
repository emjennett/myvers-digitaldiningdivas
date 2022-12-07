package APP_Business_Rules.login_user;

public class LoginUserResponseModel {

    LoginUserGatewayModel model;

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


}
