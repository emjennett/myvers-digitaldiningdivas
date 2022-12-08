package APP_Business_Rules.login_user;

public class LoginUserResponseModel {

    LoginUserGatewayModel model;


    public LoginUserResponseModel(LoginUserGatewayModel model) {
        this.model = model;
    }

    public String getUsername(){
        return this.model.getUsername();
    }

}
