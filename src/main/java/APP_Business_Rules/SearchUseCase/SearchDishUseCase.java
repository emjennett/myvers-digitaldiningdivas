package APP_Business_Rules.SearchUseCase;

import APP_Business_Rules.DataAccessStorageInterface;
import APP_Business_Rules.OutputBoundary;
import Entities.Dish;
import Entities.Review;
import Interface_and_Adapters.SearchPresenter;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Double.compare;

public class SearchDishUseCase implements SearchInputBoundary{
    private OutputBoundary searchPresenter;
    private DataAccessStorageInterface dataAccess;

    public SearchDishUseCase(OutputBoundary searchPresenter, DataAccessStorageInterface dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    public void Search(SearchRequestModel searchRequestModel){
        ArrayList<Dish> data = (ArrayList<Dish>) this.dataAccess.accessData(searchRequestModel.getType() + ".txt"); //Might need to change the return type of accessData() to Arraylist<Object>
        SearchResponseModel searchResponseModel = new SearchResponseModel(new ArrayList<>());
        for (Dish d: data){
            if(d.getName().contains(searchRequestModel.getSearch())||d.getCategory().contains(searchRequestModel.getSearch())){
                if (compare(d.getRating(), (Double) searchRequestModel.getFilter().get("minRating")) >= 0 && searchRequestModel.getFilter().get("Category") == d.getCategory()){
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
                    searchResponseModel.add(dishAsAHashMap);
                }
            }
        }
        searchPresenter.update(searchResponseModel);
    }
}
