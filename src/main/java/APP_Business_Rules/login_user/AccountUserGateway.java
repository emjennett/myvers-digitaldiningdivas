package APP_Business_Rules.login_user;

public interface AccountUserGateway {

    LoginUserGatewayModel loadAccount(LoginUserGatewayModel model);
    LoginUserGatewayModel updateBio(LoginUserGatewayModel model);
}
