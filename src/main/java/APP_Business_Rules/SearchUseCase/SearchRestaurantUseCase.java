package APP_Business_Rules.SearchUseCase;

import APP_Business_Rules.RestaurantUseCase.RestaurantDataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;

public class SearchRestaurantUseCase implements SearchInputBoundary{
    /**
     * Class that takes care of querying restaurants and filtering out the ones that do not match the search
     * @param searchPresenter presenter that updates the UI with the restaurants that match the search
     * @param dataAccess class that reads the restaurant database
     */
    private SearchOutputBoundary searchPresenter;
    private RestaurantDataAccess dataAccess;

    public SearchRestaurantUseCase(SearchOutputBoundary searchPresenter, RestaurantDataAccess dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    /**
     * Function that gets all the available restaurants and keeps the ones that match the search then calls the presenter
     * to update the UI
     * @param searchRequestModel request model that contains all the information about the search
     */
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
