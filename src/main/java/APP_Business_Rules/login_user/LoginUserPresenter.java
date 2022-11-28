package APP_Business_Rules.login_user;



public interface LoginUserPresenter {

    LoginUserResponseModel userLoggedIn(LoginUserResponseModel model);

    LoginUserResponseModel userLoginFail(String fail);
}
