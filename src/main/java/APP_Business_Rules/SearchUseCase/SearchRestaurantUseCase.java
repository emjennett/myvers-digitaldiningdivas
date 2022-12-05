package APP_Business_Rules.SearchUseCase;

import APP_Business_Rules.DataAccessStorageInterface;
import APP_Business_Rules.OutputBoundary;
import APP_Business_Rules.RestaurantUseCase.RestaurantDataAccess;
import Entities.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;

public class SearchRestaurantUseCase implements SearchInputBoundary{
    private OutputBoundary searchPresenter;
    private RestaurantDataAccess dataAccess;

    public SearchRestaurantUseCase(OutputBoundary searchPresenter, RestaurantDataAccess dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    public void Search(SearchRequestModel searchRequestModel){
        List<List<String>> data = this.dataAccess.getRes(); //Might need to change the return type of accessData() to Arraylist<Object>
        SearchResponseModel searchResponseModel = new SearchResponseModel(new ArrayList<>(), "Restaurant");
        for (List<String> r: data){
            if(r.get(0).contains(searchRequestModel.getSearch())){
                if (compare(parseDouble(r.get(3)), searchRequestModel.getMinRating()) >= 0 && (Objects.equals(searchRequestModel.getCategory(), r.get(1)) || Objects.equals(searchRequestModel.getCategory(), "All"))){
                    searchResponseModel.add(r);
                }
            }
        }
        searchPresenter.update(searchResponseModel);
    }


}
