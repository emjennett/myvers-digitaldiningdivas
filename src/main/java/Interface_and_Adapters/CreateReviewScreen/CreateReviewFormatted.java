package Interface_and_Adapters.CreateReviewScreen;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewResponseModel;

public class CreateReviewFormatted implements CreateReviewPresenter{

    @Override
    public CreateReviewResponseModel giveResponse(CreateReviewResponseModel response) {
        return response;
    }
}
