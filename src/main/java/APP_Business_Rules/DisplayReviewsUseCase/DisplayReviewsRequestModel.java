package APP_Business_Rules.DisplayReviewsUseCase;

public class DisplayReviewsRequestModel {

    private Object reviewed;

    public DisplayReviewsRequestModel(Object reviewed){
        this.reviewed = reviewed;
    }

    public Object getReviewed() {
        return reviewed;
    }
}
