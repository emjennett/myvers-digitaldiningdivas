package APP_Business_Rules.SearchUseCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchResponseModel {
    private List<List<String>> result;
    private String type;

    public SearchResponseModel(List<List<String>> result, String type) {

        this.result = result;
        this.type = type;
    }

    public List<List<String>> getResult() {
        return result;
    }

    public String getType() {
        return type;
    }

    public void add(List<String> e){
        this.result.add(e);
    }
}
