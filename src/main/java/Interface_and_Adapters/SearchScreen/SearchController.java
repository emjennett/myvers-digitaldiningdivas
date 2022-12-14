package Interface_and_Adapters.SearchScreen;

import APP_Business_Rules.SearchUseCase.*;

public class SearchController {
    private SearchInputBoundary searchDishUseCase;
    private SearchInputBoundary searchUserUseCase;
    private SearchInputBoundary searchRestaurantUseCase;

    public SearchController(SearchInputBoundary searchDishUseCase, SearchInputBoundary searchRestaurantUseCase){
        this.searchRestaurantUseCase = searchRestaurantUseCase;
        this.searchDishUseCase = searchDishUseCase;
    }

    public SearchResponseModel Search(String search, String type, String category, int minRating){
        switch (type){
            case "Restaurant":
                return this.searchRestaurantUseCase.Search(new SearchRequestModel(search,type,category, minRating));
            case "Dish":
                return this.searchDishUseCase.Search(new SearchRequestModel(search,type,category, minRating));
        }
        return null;
    }
}
