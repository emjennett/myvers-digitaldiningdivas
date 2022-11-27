package APP_Business_Rules.create_user;



public class CreateUserController {

    final CreateUserInputBoundary userInput;

    public CreateUserController(CreateUserInputBoundary userGateway){

        this.userInput = userGateway;
    }
    public CreateUserResponseModel create(String username, String password, String dup_password) {
        CreateUserRequestModel model = new CreateUserRequestModel(
                username, password, dup_password);

        return userInput.create(model);
    }
}
