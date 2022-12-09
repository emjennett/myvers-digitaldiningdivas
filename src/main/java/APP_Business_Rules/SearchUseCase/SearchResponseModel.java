package APP_Business_Rules.SearchUseCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchResponseModel {
    /**
     * Object that represents the items that match the search
     * @param result list of items that match the search, each item is represented by a list of strings
     * @param type represents the type of search made
     */
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
