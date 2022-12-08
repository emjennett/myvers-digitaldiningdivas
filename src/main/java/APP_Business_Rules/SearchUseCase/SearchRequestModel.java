package APP_Business_Rules.SearchUseCase;

import java.util.HashMap;

public class SearchRequestModel {
    private String search;
    private String type;
    private String category;
    private int minRating;

    public SearchRequestModel(String search, String type, String category, int minRating) {
        this.search = search;
        this.type = type;
        this.category = category;
        this.minRating = minRating;
    }

    public String getSearch() {
        return search;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public int getMinRating() {
        return minRating;
    }
}
