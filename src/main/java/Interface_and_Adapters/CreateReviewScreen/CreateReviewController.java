package Interface_and_Adapters.CreateReviewScreen;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewInputBoundary;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewRequestModel;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewResponseModel;
import Entities.AccountUser;
import Entities.ReviewableObject;

public class CreateReviewController {

    final CreateReviewInputBoundary userInput;

    public CreateReviewController(CreateReviewInputBoundary reviewInteractor){

        this.userInput = reviewInteractor;
    }
    public CreateReviewResponseModel create(String user, String reviewed, String review, Integer rating){

        CreateReviewRequestModel model = new CreateReviewRequestModel(user, reviewed, review, rating);

        return userInput.create(model);
    }
}
