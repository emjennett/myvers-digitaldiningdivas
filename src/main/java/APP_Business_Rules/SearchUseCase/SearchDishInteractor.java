package APP_Business_Rules.SearchUseCase;

import APP_Business_Rules.DishMenu.DishDataAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Double.compare;
import static java.lang.Integer.parseInt;

public class SearchDishInteractor implements SearchInputBoundary{
    /**
     * Class that takes care of querying dishes and filtering out the ones that do not match the search
     * @param searchPresenter presenter that updates the UI with the restaurants that match the search
     * @param dataAccess class that reads the dish database
     */
    private SearchOutputBoundary searchPresenter;
    private DishDataAccess dataAccess;

    public SearchDishInteractor(SearchOutputBoundary searchPresenter, DishDataAccess dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    /**
     * Function that gets all the available dishes and keeps the ones that match the search then calls the presenter
     * to update the UI
     *
     * @param searchRequestModel request model that contains all the information about the search
     * @return
     */
    public SearchResponseModel Search(SearchRequestModel searchRequestModel){
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
        return searchResponseModel; //returns response model for testing purposes
    }
}
