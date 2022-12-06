package Interface_and_Adapters;

import APP_Business_Rules.SearchOutputBoundary;
import APP_Business_Rules.SearchUseCase.SearchResponseModel;
import Frameworks_and_Drivers.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SearchPresenter implements SearchOutputBoundary {
    private UI view;

    @Override
    public void update(SearchResponseModel searchResponseModel) {
        List<List<String>> sortedResult = new ArrayList<>();

        //Sorting dishes
        if(Objects.equals(searchResponseModel.getType(), "Dish")) {
            for (List<String> r : searchResponseModel.getResult()) {
                if(sortedResult.isEmpty()){
                    sortedResult.add(r);
                }
                else {
                    for (int i = 0; i < sortedResult.size(); i++) {
                        if ((Double.parseDouble(sortedResult.get(i).get(1)) >= Double.parseDouble(r.get(1)))) {
                            sortedResult.add(i, r);
                            break;
                        }
                        else if(i == sortedResult.size()-1){
                            sortedResult.add(r);
                            break;
                        }
                    }
                }
            }
            Collections.reverse(sortedResult);
            String[][] data = convertToArray((sortedResult));
            view.updateDishTable(data);
        }

        //Sorting restaurants
        else if(Objects.equals(searchResponseModel.getType(), "Restaurant")) {
            for (List<String> r : searchResponseModel.getResult()) {
                if(sortedResult.isEmpty()){
                    sortedResult.add(r);
                }
                else {
                    for (int i = 0; i < sortedResult.size(); i++) {
                        if ((Double.parseDouble(sortedResult.get(i).get(3)) >= Double.parseDouble(r.get(3)))) {
                            sortedResult.add(i, r);
                            break;
                        }
                        else if(i == sortedResult.size()-1){
                            sortedResult.add(r);
                            break;
                        }
                    }
                }
            }
            Collections.reverse(sortedResult);
            String[][] data = convertToArray(sortedResult);
            view.updateRestaurantTable(data);
        }
    }

    private String[][] convertToArray(List<List<String>> sortedResult) {
        String[][] data = new String[sortedResult.size()][];
        for(int i = 0; i < sortedResult.size(); i++){
            String[] row = new String[sortedResult.get(i).size()];
            for(int j = 0; j < sortedResult.get(i).size(); j++){
                row[j] = sortedResult.get(i).get(j);
            }
            data[i] = row;
        }
        return data;
    }

    public void setView(UI view) {
        this.view = view;
    }
}
