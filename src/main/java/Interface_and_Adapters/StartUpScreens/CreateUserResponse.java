package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.create_user.CreateUserPresenter;
import APP_Business_Rules.create_user.CreateUserResponseModel;

public class CreateUserResponse implements CreateUserPresenter {
    @Override
    public CreateUserResponseModel userCreated(CreateUserResponseModel model) {
        return null;
    }

    @Override
    public CreateUserResponseModel userCreatedFail(String fail) {
        throw new SignUpFail(fail);
    }
}
