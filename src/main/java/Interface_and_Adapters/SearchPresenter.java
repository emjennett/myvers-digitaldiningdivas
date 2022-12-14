package Interface_and_Adapters;

import APP_Business_Rules.OutputBoundary;
import APP_Business_Rules.SearchUseCase.SearchResponseModel;
import Entities.Dish;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchPresenter implements OutputBoundary {
    public ArrayList<HashMap<String, String>> presentSearchedItem(String item){ // To find a given dish using the search tool
        return null;
    }

    @Override
    public void update(SearchResponseModel searchResponseModel) {
        ArrayList<HashMap<String,Object>> sortedResult = new ArrayList<>();
        for(HashMap<String,Object> r : searchResponseModel.getResult()){
            for(int i = 0; i < sortedResult.size(); i++){
                if((Integer) sortedResult.get(i).get("Rating") >= (Integer) r.get("Rating")){
                    sortedResult.add(i,r);
                }
            }
        }
        //Do something with the sorted list
    }
}
