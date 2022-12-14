package APP_Business_Rules.SearchUseCase;


public class SearchRequestModel {
    /**
     *Object that contains information about the search made
     * @param search String entered on the search bar
     * @param type type of search that could be either "Dish" or "Restaurant"
     * @param category category of the searched items
     * @param minRating minimum rating or number of Michelin stars of the searhed items
     */
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
