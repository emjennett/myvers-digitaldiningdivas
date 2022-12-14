package APP_Business_Rules.DisplayReviewsUseCase;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewInteractor;
import Entities.Review;
import Frameworks_and_Drivers.ReviewFile;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewController;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewFormatted;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsController;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsFormatted;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayReviewsInteractorTest {

    @Test
    void create() {
        ReviewFile file = new ReviewFile();
        DisplayReviewsFormatted response = new DisplayReviewsFormatted();
        DisplayReviewsInteractor interactor = new DisplayReviewsInteractor(file, response);
        DisplayReviewsController controller = new DisplayReviewsController(interactor);

        DisplayReviewsResponseModel responseModel = controller.create("Sikil Pak");
        for(Review r: responseModel.getReviews()){
            assert r.getReviewed().equals("Sikil Pak");
        }
    }
}