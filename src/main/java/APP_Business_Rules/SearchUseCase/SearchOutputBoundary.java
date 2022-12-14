package APP_Business_Rules.SearchUseCase;

import APP_Business_Rules.SearchUseCase.SearchResponseModel;
/**
 * Interface implemented by search use case presenter
 */
public interface SearchOutputBoundary {
    void update(SearchResponseModel searchResponseModel);
}
