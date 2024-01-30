package Interface_and_Adapters.start_up_screens;

import APP_Business_Rules.login_user.LoginUserInputBoundary;
import APP_Business_Rules.login_user.LoginUserRequestModel;
import APP_Business_Rules.login_user.LoginUserResponseModel;

public class LoginUserController {

    final LoginUserInputBoundary userInput;

    /**
     * Starts the process to take user input from a login screen.
     * @param userInput interface need to create a ResponseModel.
     */
    public LoginUserController(LoginUserInputBoundary userInput) {
        this.userInput = userInput;
    }
    /**
     * Prepares a response model if a user can be successfully logged into.
     * @param username input from a user to log into an account.
     * @param password input from a user to have access to the account.
     */
    public LoginUserResponseModel login(String username, String password){
        LoginUserRequestModel model = new LoginUserRequestModel(username, password);

        return userInput.login(model);

    }
}
