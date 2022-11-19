package APP_Business_Rules;

import Entities.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;

public class SearchRestaurantUseCase {
    private OutputBoundary searchPresenter;
    private DataAccessStorageInterface dataAccess;

    public SearchRestaurantUseCase(OutputBoundary searchPresenter, DataAccessStorageInterface dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    public void Search(String search, String type, HashMap<String, Object> filter){
        ArrayList<Restaurant> data = (ArrayList<Restaurant>) this.dataAccess.accessData(type + ".txt"); //Might need to change the return type of accessData() to Arraylist<Object>
        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        for (Restaurant r: data){
            if(r.getName().contains(search)||r.getLocation().contains(search)){
                if (compare(r.getRating(), (Double) filter.get("minRating")) >= 0 && filter.get("Category") == r.getResCategory()){
                    HashMap<String, Object> restaurantAsAHashMap = new HashMap<String, Object>();
                    restaurantAsAHashMap.put("Name", r.getName());
                    restaurantAsAHashMap.put("Restaurant Category", r.getResCategory());
                    restaurantAsAHashMap.put("Location", r.getLocation());
                    restaurantAsAHashMap.put("Rating", r.getRating());
                    //Omitted dishRatings because I do not know if it will be kept
                    //Will format the menu into a HashMap when I get a better idea of the what is happening in the Menu code
                    result.add(restaurantAsAHashMap);
                }
            }
        }
        //Need to sort this
        searchPresenter.update(result);
    }

}
