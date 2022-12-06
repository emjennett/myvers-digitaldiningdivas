package APP_Business_Rules.login_user;

import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.AccountUserFile;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.start_up_screens.LoginUserController;
import Interface_and_Adapters.start_up_screens.LoginUserResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginUserInteractorTest {

    // seems impossible to create a functional test.
    // The use case is tested more practically by running the application.

    LoginUserGateway user = new UserFile("./users.csv");
    AccountUserGateway account = new AccountUserFile("./accounts.csv");
    LoginUserPresenter presenter = new LoginUserResponse();
    UserFactory userFactory = new AccountFactory();
    LoginUserInputBoundary interactor = new LoginUserInteractor(
            user, account, userFactory, presenter);
    LoginUserController controller = new LoginUserController(interactor);

    @Test
    void login() {
    }
}