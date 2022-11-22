package APP_Business_Rules.create_user;

import APP_Business_Rules.create_user.CreateUserInputBoundary;
import APP_Business_Rules.create_user.CreateUserRequestModel;
import APP_Business_Rules.create_user.CreateUserResponseModel;


public class CreateUserController {

    final CreateUserInputBoundary userInput;

    public CreateUserController(CreateUserInputBoundary userGateway){

        this.userInput = userGateway;
    }
    CreateUserResponseModel create(String username, String password, String dup_password) {
        CreateUserRequestModel model = new CreateUserRequestModel(
                username, password, dup_password);

        return userInput.create(model);
    }
}
