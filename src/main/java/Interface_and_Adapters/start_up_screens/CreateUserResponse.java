package Interface_and_Adapters.start_up_screens;

import APP_Business_Rules.create_user.CreateUserPresenter;
import APP_Business_Rules.create_user.CreateUserResponseModel;

public class CreateUserResponse implements CreateUserPresenter {

    /**
     * The optional successful account creation method returns nothing.
     * @param model the response for creating a user.
     */
    @Override
    public CreateUserResponseModel userCreated(CreateUserResponseModel model) {
        return null;
    }

    /**
     * The unsuccessful method for creating the account.
     * @param fail the response passed for unsuccessful account creation.
     */
    @Override
    public CreateUserResponseModel userCreatedFail(String fail) {
        throw new SignUpFail(fail);
    }
}
