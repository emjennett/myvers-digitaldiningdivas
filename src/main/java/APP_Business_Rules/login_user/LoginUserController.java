package APP_Business_Rules.login_user;

public class LoginUserController {

    final LoginUserInputBoundary userInput;

    public LoginUserController(LoginUserInputBoundary userInput) {
        this.userInput = userInput;
    }

    public LoginUserResponseModel login(String username, String password){
        LoginUserRequestModel model = new LoginUserRequestModel(username, password);

        return userInput.login(model);

    }
}
