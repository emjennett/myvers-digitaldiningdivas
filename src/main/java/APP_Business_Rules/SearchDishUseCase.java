package APP_Business_Rules;

import Entities.Dish;
import Entities.Review;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Double.compare;

public class SearchDishUseCase {
    private OutputBoundary searchPresenter;
    private DataAccessStorageInterface dataAccess;

    public SearchDishUseCase(OutputBoundary searchPresenter, DataAccessStorageInterface dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    public void Search(String search, String type, HashMap<String, Object> filter){
        ArrayList<Dish> data = (ArrayList<Dish>) this.dataAccess.accessData(type + ".txt"); //Might need to change the return type of accessData() to Arraylist<Object>
        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        for (Dish d: data){
            if(d.getName().contains(search)||d.getCategory().contains(search)){
                if (compare(d.getRating(), (Double) filter.get("minRating")) >= 0 && filter.get("Category") == d.getCategory()){
                    HashMap<String, Object> dishAsAHashMap = new HashMap<>();
                    dishAsAHashMap.put("Name", d.getName());
                    dishAsAHashMap.put("Dish Category", d.getCategory());
                    dishAsAHashMap.put("Rating", d.getRating());
                    ArrayList<HashMap<String, Object>> formatedReviews = new ArrayList<>();
                    for (Review r : d.getReviews()){
                        HashMap<String, Object> formattedReview = new HashMap<>();
                        formattedReview.put("Review", r.getReview());
                        formattedReview.put("Author", r.getAuthor());
                        formattedReview.put("Created on", r.getCreatedOn());
                        formattedReview.put("Rating", r.getRating());
                        //I did not put dishReviewed because I don't see why I would need it
                        formatedReviews.add(formattedReview);
                    }
                    dishAsAHashMap.put("Reviews", formatedReviews);
                    result.add(dishAsAHashMap);
                }
            }
        }
        // I should sort this too
        searchPresenter.update(result);
    }
}
