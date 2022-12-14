package APP_Business_Rules.SearchUseCase;

import java.util.HashMap;

public class SearchRequestModel {
    private String search;
    private String type;
    private HashMap<String, Object> filter;

    public SearchRequestModel(String search, String type, HashMap<String, Object> filter) {
        this.search = search;
        this.type = type;
        this.filter = filter;
    }

    public String getSearch() {
        return search;
    }

    public String getType() {
        return type;
    }

    public HashMap<String, Object> getFilter() {
        return filter;
    }
}