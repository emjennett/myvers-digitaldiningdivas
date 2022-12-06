package Interface_and_Adapters;

import APP_Business_Rules.MenuUseCase.MenuOutputBoundary;
import APP_Business_Rules.MenuUseCase.MenuResponseModel;
import APP_Business_Rules.SearchOutputBoundary;
import Frameworks_and_Drivers.UI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuPresenter implements MenuOutputBoundary {
    private UI view;
    @Override
    public void update(MenuResponseModel menuResponseModel) {
        List<List<String>> sortedResult = new ArrayList<>();
        for (List<String> r : menuResponseModel.getDishList()) {
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
        String[][] data = new String[sortedResult.size()][];
        for(int i = 0; i < sortedResult.size(); i++){
            String[] row = new String[sortedResult.get(i).size()];
            for(int j = 0; j < sortedResult.get(i).size(); j++){
                row[j] = sortedResult.get(i).get(j);
            }
            data[i] = row;
        }
        view.updateMenuTable(data);
    }

    public void setView(UI view) {
        this.view = view;
    }
}
