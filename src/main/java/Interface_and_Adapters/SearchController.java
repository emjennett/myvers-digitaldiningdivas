package Interface_and_Adapters;

import APP_Business_Rules.SearchDishUseCase;
import APP_Business_Rules.SearchRestaurantUseCase;
import APP_Business_Rules.SearchUserUseCase;
import Frameworks_and_Drivers.DataAccessStorage;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Double.parseDouble;

public class SearchController {
    private SearchDishUseCase searchDishUseCase;
    private SearchUserUseCase searchUserUseCase;
    private SearchRestaurantUseCase searchRestaurantUseCase;

    public SearchController(){
        this.searchRestaurantUseCase = new SearchRestaurantUseCase(new SearchPresenter(), new DataAccessStorage());
        this.searchDishUseCase = new SearchDishUseCase(new SearchPresenter(), new DataAccessStorage());
        this.searchUserUseCase = new SearchUserUseCase(new SearchPresenter(), new DataAccessStorage());
    }

    public void Search(String search, String type, HashMap<String, Object> filter){
        filter.put("minRating", parseDouble((String) filter.get("minRating")));
        switch (type){
            case "Restaurant":
                this.searchRestaurantUseCase.Search(search,type,filter);
                break;
            case "Dish":
                this.searchDishUseCase.Search(search,type,filter);
                break;
            case "User":
                this.searchUserUseCase.Search(search,type,filter);
                break;
        }
    }
}
