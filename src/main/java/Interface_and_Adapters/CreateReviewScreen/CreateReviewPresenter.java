package Interface_and_Adapters.CreateReviewScreen;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewResponseModel;

public interface CreateReviewPresenter {

    public CreateReviewResponseModel giveResponse(CreateReviewResponseModel responseModel);
}
