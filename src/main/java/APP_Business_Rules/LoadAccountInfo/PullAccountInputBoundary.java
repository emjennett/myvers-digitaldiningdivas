package APP_Business_Rules.LoadAccountInfo;

import APP_Business_Rules.login_user.LoginUserResponseModel;

public interface PullAccountInputBoundary {


    LoginUserResponseModel UpdateBio(UpdateRequestModel requestModel);

}

