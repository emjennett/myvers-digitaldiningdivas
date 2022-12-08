package APP_Business_Rules;

import APP_Business_Rules.SearchUseCase.SearchResponseModel;

public interface SearchOutputBoundary {
    void update(SearchResponseModel searchResponseModel);
}
