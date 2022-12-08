package Interface_and_Adapters.start_up_screens;


import APP_Business_Rules.create_user.CreateUserInputBoundary;
import APP_Business_Rules.create_user.CreateUserRequestModel;
import APP_Business_Rules.create_user.CreateUserResponseModel;

public class CreateUserController {

    final CreateUserInputBoundary userInput;
    // Interface adapter layer
    /**
     * @param userGateway interface need to create a ResponseModel.
     */
    public CreateUserController(CreateUserInputBoundary userGateway){

        this.userInput = userGateway;
    }

    /**
     * The method that will interact with a request model to return the response model.
     * @param  username chosen by the user input.
     * @param password chosen by the user input.
     * @param dup_password chosen by the user input.
     */
    public CreateUserResponseModel create(String username, String password, String dup_password, String type) {
        CreateUserRequestModel model = new CreateUserRequestModel(
                username, password, dup_password, type);

        return userInput.create(model);
    }
}
