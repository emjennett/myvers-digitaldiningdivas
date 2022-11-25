package APP_Business_Rules;

import APP_Business_Rules.SearchUseCase.SearchResponseModel;

import java.util.ArrayList;
import java.util.HashMap;

public interface OutputBoundary {
    void update(SearchResponseModel searchResponseModel);
}
