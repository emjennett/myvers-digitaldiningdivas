package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.login_user.LoginUserPresenter;
import APP_Business_Rules.login_user.LoginUserResponseModel;

public class LoginUserResponse implements LoginUserPresenter {
    @Override
    public LoginUserResponseModel userLoggedIn(LoginUserResponseModel model) {
        return model;
    }

    @Override
    public LoginUserResponseModel userLoginFail(String fail) {
        throw new LoginFail(fail);
    }
}
