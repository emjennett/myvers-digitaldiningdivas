package Interface_and_Adapters;

import APP_Business_Rules.OutputBoundary;
import Entities.Dish;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchPresenter implements OutputBoundary {
    public ArrayList<HashMap<String, String>> presentSearchedItem(String item){ // To find a given dish using the search tool
        return null;
    }

    @Override
    public void update(ArrayList<HashMap<String, Object>> result) {
        //Need to complete this
    }
}
