package APP_Business_Rules.SearchUseCase;

import APP_Business_Rules.DishMenu.DishFileReader;
import APP_Business_Rules.RestaurantUseCase.RestaurantFileReader;
import Interface_and_Adapters.SearchScreen.SearchController;
import Interface_and_Adapters.SearchScreen.SearchPresenter;
import Interface_and_Adapters.SearchScreen.SearchScreen;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Integer.parseInt;

class SearchInteractorTest {
    RestaurantFileReader restaurantFileReader = new RestaurantFileReader("Restaurant.csv");
    DishFileReader dishFileReader = new DishFileReader("Frameworks_and_Drivers/Dishes.csv");
    SearchPresenter searchPresenter = new SearchPresenter();
    SearchRestaurantInteractor searchRestaurantInteractor = new SearchRestaurantInteractor(searchPresenter, restaurantFileReader);
    SearchDishInteractor searchDishInteractor = new SearchDishInteractor(searchPresenter, dishFileReader);
    SearchController searchController = new SearchController(searchRestaurantInteractor, searchDishInteractor);
    SearchScreen searchScreen = new SearchScreen(searchController,null,null);
    @Test
    void dishSearch() {
        searchPresenter.setView(searchScreen);
        SearchResponseModel searchResponseModel = searchController.Search("o","Dish", "Entree", 9);
        for(List<String> l: searchResponseModel.getResult()){
            assert l.get(1).contains("o");
            assert parseInt(l.get(2)) >= 9;
            assert l.get(4).equals("Entree");
        }
    }

    @Test
    void restaurantSearch() {
        searchPresenter.setView(searchScreen);
        SearchResponseModel searchResponseModel = searchController.Search("e","Restaurant", "Mediterranean", 0);
        for(List<String> l: searchResponseModel.getResult()){
            assert l.get(0).contains("e");
            assert parseInt(l.get(3)) >= 0;
            assert l.get(1).equals("Mediterranean");
        }
    }
}