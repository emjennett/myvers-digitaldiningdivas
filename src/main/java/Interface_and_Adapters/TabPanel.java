package Interface_and_Adapters;

import APP_Business_Rules.DishMenu.*;
import APP_Business_Rules.RestaurantUseCase.*;
//import APP_Business_Rules.RestaurantUseCase.RestaurantFormatted;
import Interface_and_Adapters.start_up_screens.ProfileScreen;
import Interface_and_Adapters.restaurant_screens.*;




import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.*;
import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishFormatted;
import Interface_and_Adapters.DishMenuScreens.DishPresenter;
import Interface_and_Adapters.DishMenuScreens.DishScreen;

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
        res = new RestaurantFileReader("src/main/java/Frameworks_and_Drivers/Restaurant.csv");

        DishDataAccess dish = new DishFileReader("src/main/java/Frameworks_and_Drivers/Dishes.csv");


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


      
        ProfileScreen welcomeScreen = new ProfileScreen(account, mainPanel);
        RestaurantScreen restaurantScreen = new RestaurantScreen(restaurantController);

       
        RestaurantScreen restaurantScreen = new RestaurantScreen(restaurantController, account.getUsername());
        DishScreen dishScreen = new DishScreen(dishController);

//        AnalyticsScreen analyticsScreen = new AnalyticsScreen();
//        RankingScreen rankingScreen = new RankingScreen();

        //adds windows with labels to tab layout. This is an example of what a Restaurant Owner would see.
        tabs.addTab("Home", welcomeScreen);
        tabs.addTab("Restaurant", restaurantScreen);
//        tabs.addTab("Rankings", rankingScreen);
//        tabs.addTab("Analytics", analyticsScreen);
        tabs.addTab("Dishes", dishScreen);

        this.add(tabs);
        //JOptionPane.showMessageDialog(this, "Welcome " + account.getUsername() + "!");
    }
}
