package Interface_and_Adapters;

import APP_Business_Rules.SearchUseCase.*;
import Frameworks_and_Drivers.DataAccessStorage;

import java.util.HashMap;

import static java.lang.Double.parseDouble;

public class SearchController {
    private SearchInputBoundary searchDishUseCase;
    private SearchInputBoundary searchUserUseCase;
    private SearchInputBoundary searchRestaurantUseCase;

    public SearchController(SearchInputBoundary searchDishUseCase, SearchInputBoundary searchUserUseCase, SearchInputBoundary searchRestaurantUseCase){
        this.searchRestaurantUseCase = searchRestaurantUseCase;
        this.searchDishUseCase = searchDishUseCase;
        this.searchUserUseCase = searchUserUseCase;
    }

    public void Search(String search, String type, HashMap<String, Object> filter){
        filter.put("minRating", parseDouble((String) filter.get("minRating")));
        switch (type){
            case "Restaurant":
                this.searchRestaurantUseCase.Search(new SearchRequestModel(search,type,filter));
                break;
            case "Dish":
                this.searchDishUseCase.Search(new SearchRequestModel(search,type,filter));
                break;
            case "User":
                this.searchUserUseCase.Search(new SearchRequestModel(search,type,filter));
                break;
        }
    }
}
