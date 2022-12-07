package Interface_and_Adapters.DisplayReviewsScreen;

import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsResponseModel;

public class DisplayReviewsFormatted implements DisplayReviewsPresenter{

    @Override
    public DisplayReviewsResponseModel giveResponse(DisplayReviewsResponseModel response) {
        return response;
    }
}
