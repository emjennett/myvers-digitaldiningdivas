package Interface_and_Adapters;

import APP_Business_Rules.OutputBoundary;
import APP_Business_Rules.SearchUseCase.SearchResponseModel;
import Entities.Dish;
import Frameworks_and_Drivers.UI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SearchPresenter implements OutputBoundary {
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
                    }
                }
            }
            view.updateDishtTable(sortedResult);
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
                    }
                }
            }
            view.updateRestaurantTable(sortedResult);
        }
    }

    public void setView(UI view) {
        this.view = view;
    }
}
