package APP_Business_Rules.SearchUseCase;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchResponseModel {
    private ArrayList<HashMap<String,Object>> result;

    public SearchResponseModel(ArrayList<HashMap<String, Object>> result) {
        this.result = result;
    }

    public ArrayList<HashMap<String, Object>> getResult() {
        return result;
    }

    public void add(HashMap<String,Object> e){
        this.result.add(e);
    }
}
