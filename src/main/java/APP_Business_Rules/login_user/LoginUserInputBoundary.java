package APP_Business_Rules.login_user;


import APP_Business_Rules.LoadAccountInfo.UpdateRequestModel;

public interface LoginUserInputBoundary {

    LoginUserResponseModel login(LoginUserRequestModel requestModel);
}
