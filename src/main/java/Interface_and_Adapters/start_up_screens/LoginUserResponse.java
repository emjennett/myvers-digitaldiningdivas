package Interface_and_Adapters.start_up_screens;

import APP_Business_Rules.login_user.LoginUserPresenter;
import APP_Business_Rules.login_user.LoginUserResponseModel;

public class LoginUserResponse implements LoginUserPresenter {

    /**
     * The successful account login method returns a username model.
     * @param model the response for creating a login attempt.
     */
    @Override
    public LoginUserResponseModel userLoggedIn(LoginUserResponseModel model) {
        return model;
    }

    /**
     * The unsuccessful account login attempt.
     * @param fail response for login attempt.
     */
    @Override
    public LoginUserResponseModel userLoginFail(String fail) {
        throw new LoginFail(fail);
    }
}
