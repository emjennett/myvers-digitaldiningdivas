package APP_Business_Rules.create_user;


import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.start_up_screens.CreateUserController;
import Interface_and_Adapters.start_up_screens.CreateUserResponse;
import org.junit.jupiter.api.Test;



class CreateUserInteractorTest {

    // seems impossible to create a functional test.
    // The use case is tested more practically by running the application.
    CreateUserGateway user = new UserFile("./users.csv");
    CreateUserPresenter presenter = new CreateUserResponse();
    UserFactory userFactory = new AccountFactory();
    CreateUserInputBoundary interactor = new CreateUserInteractor(
            user, userFactory, presenter);
    CreateUserController controller = new CreateUserController(interactor);

    //CreateUserRequestModel request = new CreateUserRequestModel("pat", "pass", "pass");


    @Test
    void create() {

    }
}