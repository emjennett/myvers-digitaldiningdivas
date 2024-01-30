package APP_Business_Rules.login_user;

import APP_Business_Rules.LoadAccountInfo.UpdateRequestModel;
import APP_Business_Rules.LoadAccountInfo.UserAccountInfoModel;
import APP_Business_Rules.RestaurantUseCase.RestaurantGatewayModel;
import APP_Business_Rules.create_user.CreateUserGatewayModel;
import Entities.Loggable;
import Entities.UserFactory;

public class LoginUserInteractor implements LoginUserInputBoundary {

    final LoginUserGateway loginGateway;

    final AccountUserGateway accountGateway;

    final UserFactory factory;

    final LoginUserPresenter presenter;

    /**
     * The Use case interactor called when a user wants to log in with a created account.
     * @param loginGateway interface needed to see if the account exists and
     *                     if the password matches the username.
     * @param accountGateway interface gateway need to log in for the first time or grab the user's username.
     * @param factory interface needed to create a loggable user.
     * @param presenter interface needed to send log in results to the user.
     */

    public LoginUserInteractor(LoginUserGateway loginGateway, AccountUserGateway accountGateway,
                               UserFactory factory, LoginUserPresenter presenter) {

        this.loginGateway = loginGateway;
        this.accountGateway = accountGateway;
        this.factory = factory;
        this.presenter = presenter;
    }
    /**
     * The use case login method starts the process to return a result response to the presenter.
     * @param model the request model that encompasses information to request an account log
     *              in.
     */
    @Override
    public LoginUserResponseModel login(LoginUserRequestModel model) {
        CreateUserGatewayModel gateway = loginGateway.confirmAccountUser(model.getUsername(), model.getPassword());
        if (gateway == null) {
            return presenter.userLoginFail("Your Username or Password are Incorrect!");
        }

        Loggable loginUser = factory.loginUser(model.getUsername(), model.getPassword(), gateway.getType(), gateway.getDate(), gateway.getImg(), gateway.getFavRestaurants());



        LoginUserGatewayModel LoginDataModel = new LoginUserGatewayModel(loginUser.getUserName(), loginUser.getType(), loginUser.getDate(), gateway.getImg(), gateway.getFavRestaurants(), gateway.getNewRes());

        LoginUserResponseModel LoggedInUser = new LoginUserResponseModel(accountGateway.loadAccount(LoginDataModel));
        LoggedInUser.setDate(gateway.getDate());
        LoggedInUser.setPic(gateway.getImg());
        LoggedInUser.setFavRestaurants(gateway.getFavRestaurants());

        return presenter.userLoggedIn(LoggedInUser);
    }


}
