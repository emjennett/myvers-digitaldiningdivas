package APP_Business_Rules.SearchUseCase;

import APP_Business_Rules.DataAccessStorageInterface;
import APP_Business_Rules.OutputBoundary;
import Entities.AccountUser;
import Entities.Review;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Double.compare;

public class SearchUserUseCase implements SearchInputBoundary{
    private OutputBoundary searchPresenter;
    private DataAccessStorageInterface dataAccess;

    public SearchUserUseCase(OutputBoundary searchPresenter, DataAccessStorageInterface dataAccess){
        this.searchPresenter = searchPresenter;
        this.dataAccess = dataAccess;
    }

    public void Search(SearchRequestModel searchRequestModel){
        ArrayList<AccountUser> data = (ArrayList<AccountUser>) this.dataAccess.accessData(searchRequestModel.getType() + ".txt"); //Might need to change the return type of accessData() to Arraylist<Object>
        SearchResponseModel searchResponseModel = new SearchResponseModel(new ArrayList<>());
        for (AccountUser a: data){
            if(a.getUserName().contains(searchRequestModel.getSearch())){
                if(compare(a.getScore(), (Double) searchRequestModel.getFilter().get("minScore")) >= 0) {
                    HashMap<String, Object> userAsAHashMap = new HashMap<>();
                    userAsAHashMap.put("Name", a.getUserName());
                    userAsAHashMap.put("Rating", a.getScore());
                    ArrayList<HashMap<String, Object>> formatedReviews = new ArrayList<>();
                    for (Review r : a.getUserReviews()){
                        HashMap<String, Object> formattedReview = new HashMap<>();
                        formattedReview.put("Review", r.getReview());
                        formattedReview.put("Author", r.getAuthor());
                        formattedReview.put("Created on", r.getCreatedOn());
                        formattedReview.put("Rating", r.getRating());
                        //I did not put dishReviewed because I don't see why I would need it
                        formatedReviews.add(formattedReview);
                    }
                    userAsAHashMap.put("Reviews", formatedReviews);
                    searchResponseModel.add(userAsAHashMap);
                }
            }
        }
        searchPresenter.update(searchResponseModel);
    }
}