package APP_Business_Rules.login_user;


import APP_Business_Rules.create_user.CreateUserGatewayModel;

public interface LoginUserGateway {

    CreateUserGatewayModel confirmAccountUser(String username, String password);

}