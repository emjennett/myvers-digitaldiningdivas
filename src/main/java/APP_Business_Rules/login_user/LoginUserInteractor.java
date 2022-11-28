package APP_Business_Rules.login_user;

import Entities.Loggable;
import Entities.UserFactory;

public class LoginUserInteractor implements LoginUserInputBoundary {

    final LoginUserGateway loginGateway;

    final AccountUserGateway accountGateway;

    final UserFactory factory;

    final LoginUserPresenter presenter;

    public LoginUserInteractor(LoginUserGateway loginGateway, AccountUserGateway accountGateway,
                               UserFactory factory, LoginUserPresenter presenter) {

        this.loginGateway = loginGateway;
        this.accountGateway = accountGateway;
        this.factory = factory;
        this.presenter = presenter;
    }

    @Override
    public LoginUserResponseModel login(LoginUserRequestModel model) {
        if (!loginGateway.confirmAccountUser(model.getUsername(), model.getPassword())) {
            return presenter.userLoginFail("Your Username or Password are Incorrect!");
        }
        Loggable loginUser = factory.loginUser(model.getUsername(), model.getPassword());
        LoginUserGatewayModel LoginDataModel = new LoginUserGatewayModel(loginUser.getUserName());
        LoginUserResponseModel LoggedInUser = new LoginUserResponseModel(accountGateway.loadAccount(LoginDataModel));
        return presenter.userLoggedIn(LoggedInUser);
    }
}
