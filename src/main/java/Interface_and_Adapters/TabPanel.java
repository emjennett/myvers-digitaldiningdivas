package Interface_and_Adapters;

import APP_Business_Rules.DishMenu.*;
import APP_Business_Rules.RestaurantUseCase.*;

import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishFormatted;
import Interface_and_Adapters.DishMenuScreens.DishPresenter;
import Interface_and_Adapters.DishMenuScreens.DishScreen;
import Interface_and_Adapters.restaurant_screens.RestaurantController;
import Interface_and_Adapters.restaurant_screens.RestaurantFormatted;
import Interface_and_Adapters.restaurant_screens.RestaurantPresenter;
import Interface_and_Adapters.restaurant_screens.RestaurantScreen;

import javax.swing.*;
import java.io.IOException;


public class TabPanel extends JPanel{
    private JPanel mainPanel;
    private LoginUserResponseModel account;

    public TabPanel(JPanel mainPanel, LoginUserResponseModel account) throws IOException {
        this.mainPanel = mainPanel;
        this.account = account;

        JTabbedPane tabs = new JTabbedPane();

        RestaurantDataAccess res;
        res = new RestaurantFileReader("./Restaurant.csv");

        DishDataAccess dish = new DishFileReader("./Dishes.csv");


        RestaurantPresenter presenter = new RestaurantFormatted();
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        RestaurantInputBoundary interactor = new RestaurantInteractor(
                res, presenter, restaurantFactory);
        RestaurantController restaurantController = new RestaurantController(
                interactor);

        DishPresenter dishPresenter = new DishFormatted();
        DishFactory dishFactory = new DishFactory();
        DishInputBoundary dishInteractor = new DishInteractor(dish, dishPresenter, dishFactory);
        DishController dishController = new DishController(dishInteractor);

        WelcomeScreen welcomeScreen = new WelcomeScreen(account, mainPanel, restaurantController);
        RestaurantScreen restaurantScreen = new RestaurantScreen(restaurantController, account.getUsername());

        DishScreen dishScreen = new DishScreen(dishController);

        //adds windows with labels to tab layout. This is an example of what a Restaurant Owner would see.
        tabs.addTab("Home", welcomeScreen);
        tabs.addTab("Restaurant", restaurantScreen);
        tabs.addTab("Dishes", dishScreen);

        this.add(tabs);

    }
}
