package APP_Business_Rules.DisplayReviewsUseCase;

import Entities.Review;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsPresenter;

import java.util.List;

public class DisplayReviewsInteractor implements DisplayReviewsInputBoundary {

    final DisplayReviewsGateway gateway;

    final DisplayReviewsPresenter presenter;

    public DisplayReviewsInteractor(DisplayReviewsGateway gateway, DisplayReviewsPresenter presenter){
        this.gateway = gateway;
        this.presenter = presenter;
    }

    @Override
    public DisplayReviewsResponseModel create(DisplayReviewsRequestModel requestModel) {
        List<Review> reviews = gateway.retrieveReviews(requestModel.getReviewed());
        DisplayReviewsResponseModel responseModel = new DisplayReviewsResponseModel(reviews);
        return responseModel;
    }
}
