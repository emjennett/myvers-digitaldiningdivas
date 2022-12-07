package Interface_and_Adapters.DisplayReviewsScreen;

import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsResponseModel;

public interface DisplayReviewsPresenter {

    public DisplayReviewsResponseModel giveResponse(DisplayReviewsResponseModel responseModel);
}
