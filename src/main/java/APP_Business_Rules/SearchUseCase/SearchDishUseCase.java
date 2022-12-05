package APP_Business_Rules.SearchUseCase;

import APP_Business_Rules.DataAccessStorageInterface;
import APP_Business_Rules.DishMenu.DishDataAccess;
import APP_Business_Rules.OutputBoundary;
import Entities.Dish;
import Entities.Review;
import Interface_and_Adapters.SearchPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class SearchDishUseCase implements SearchInputBoundary{
    private OutputBoundary searchPresenter;
    private DishDataAccess dataAccess;

    public SearchDishUseCase(OutputBoundary searchPresenter, DishDataAccess dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    public void Search(SearchRequestModel searchRequestModel){
        List<List<List<String>>> data = new ArrayList<>(dataAccess.getDish("src/main/java/Frameworks_and_Drivers/Dishes.csv").values()); //Might need to change the return type of accessData() to Arraylist<Object>
        SearchResponseModel searchResponseModel = new SearchResponseModel(new ArrayList<>(), "Dish");
        for (List<List<String>> m: data){
            for(List<String> d : m) {
                if (d.get(0).contains(searchRequestModel.getSearch())||d.get(2).contains(searchRequestModel.getSearch())) {
                    if (compare(parseInt(d.get(1)), searchRequestModel.getMinRating()) >= 0 && (Objects.equals(searchRequestModel.getCategory(), d.get(3)) || Objects.equals(searchRequestModel.getCategory(), "All"))) {
                        searchResponseModel.add(d);
                    }
                }
            }
        }
        searchPresenter.update(searchResponseModel);
    }
}
