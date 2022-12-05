package APP_Business_Rules.CreateReviewUseCase;
import Entities.Review;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewPresenter;


public class CreateReviewInteractor implements CreateReviewInputBoundary {

    final CreateReviewGateway gateway;
    final CreateReviewPresenter presenter;

    public CreateReviewInteractor(CreateReviewGateway gateway, CreateReviewPresenter presenter){

        this.gateway = gateway;
        this.presenter = presenter;
    }

    @Override
    public CreateReviewResponseModel create(CreateReviewRequestModel requestModel) {
        Review review = new Review(requestModel.getUser(), requestModel.getReview(),
                requestModel.getReviewed(), requestModel.getRating());
        gateway.save(requestModel.getReviewed(), review);
        CreateReviewResponseModel responseModel = new CreateReviewResponseModel();
        return presenter.giveResponse(responseModel);

    }
}
