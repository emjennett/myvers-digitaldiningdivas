package APP_Business_Rules.SearchUseCase;

import APP_Business_Rules.DataAccessStorageInterface;
import APP_Business_Rules.OutputBoundary;
import Entities.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;

public class SearchRestaurantUseCase implements SearchInputBoundary{
    private OutputBoundary searchPresenter;
    private DataAccessStorageInterface dataAccess;

    public SearchRestaurantUseCase(OutputBoundary searchPresenter, DataAccessStorageInterface dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    public void Search(SearchRequestModel searchRequestModel){
        ArrayList<Restaurant> data = (ArrayList<Restaurant>) this.dataAccess.accessData(searchRequestModel.getType() + ".txt"); //Might need to change the return type of accessData() to Arraylist<Object>
        SearchResponseModel searchResponseModel = new SearchResponseModel(new ArrayList<>());
        for (Restaurant r: data){
            if(r.getName().contains(searchRequestModel.getSearch())||r.getLocation().contains(searchRequestModel.getSearch())){
                if (compare(r.getRating(), (Double) searchRequestModel.getFilter().get("minRating")) >= 0 && searchRequestModel.getFilter().get("Category") == r.getResCategory()){
                    HashMap<String, Object> restaurantAsAHashMap = new HashMap<String, Object>();
                    restaurantAsAHashMap.put("Name", r.getName());
                    restaurantAsAHashMap.put("Restaurant Category", r.getResCategory());
                    restaurantAsAHashMap.put("Location", r.getLocation());
                    restaurantAsAHashMap.put("Rating", r.getRating());
                    //Omitted dishRatings because I do not know if it will be kept
                    //Will format the menu into a HashMap when I get a better idea of the what is happening in the Menu code
                    searchResponseModel.add(restaurantAsAHashMap);
                }
            }
        }
        searchPresenter.update(searchResponseModel);
    }


}