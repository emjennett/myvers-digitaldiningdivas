package APP_Business_Rules.CreateReviewUseCase;

import APP_Business_Rules.create_user.CreateUserGateway;
import APP_Business_Rules.create_user.CreateUserInputBoundary;
import APP_Business_Rules.create_user.CreateUserInteractor;
import APP_Business_Rules.create_user.CreateUserPresenter;
import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.ReviewFile;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewController;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewFormatted;
import Interface_and_Adapters.start_up_screens.CreateUserController;
import Interface_and_Adapters.start_up_screens.CreateUserResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateReviewInteractorTest {

    @Test
    void create() {
        ReviewFile file = new ReviewFile();
        CreateReviewFormatted response = new CreateReviewFormatted();
        CreateReviewInteractor interactor = new CreateReviewInteractor(file, response);
        CreateReviewController controller = new CreateReviewController(interactor);
        assert "Success!".equals(controller.create("John", "Sikil Pak", "nice", 5).CreateReviewResponse());
    }
}