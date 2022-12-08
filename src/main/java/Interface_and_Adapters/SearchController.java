package Interface_and_Adapters;

import APP_Business_Rules.SearchUseCase.*;
import Frameworks_and_Drivers.DataAccessStorage;

import java.util.HashMap;

import static java.lang.Double.parseDouble;

public class SearchController {
    private SearchInputBoundary searchDishUseCase;
    private SearchInputBoundary searchUserUseCase;
    private SearchInputBoundary searchRestaurantUseCase;

    public SearchController(SearchInputBoundary searchDishUseCase, SearchInputBoundary searchRestaurantUseCase){
        this.searchRestaurantUseCase = searchRestaurantUseCase;
        this.searchDishUseCase = searchDishUseCase;
    }

    public void Search(String search, String type, String category, int minRating){
        switch (type){
            case "Restaurant":
                this.searchRestaurantUseCase.Search(new SearchRequestModel(search,type,category, minRating));
                break;
            case "Dish":
                this.searchDishUseCase.Search(new SearchRequestModel(search,type,category, minRating));
                break;
        }
    }
}
