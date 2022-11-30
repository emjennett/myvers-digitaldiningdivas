package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.RestaurantUseCase.*;
import APP_Business_Rules.RestaurantUseCase.RestaurantFormatted;
import Interface_and_Adapters.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class TabPanel extends JPanel{
    private JPanel mainPanel;

    public TabPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;

        JTabbedPane tabs = new JTabbedPane();

        RestaurantDataAccess res;
        res = new RestaurantFileReader();


        RestaurantPresenter presenter = new RestaurantFormatted();
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        RestaurantInputBoundary interactor = new RestaurantInteractor(
                res, presenter, restaurantFactory);
        RestaurantController restaurantController = new RestaurantController(
                interactor);

        RestaurantScreen restaurantScreen = new RestaurantScreen(restaurantController);

        AnalyticsScreen analyticsScreen = new AnalyticsScreen();
        RankingScreen rankingScreen = new RankingScreen();


        //adds windows with labels to tab layout. This is an example of what a Restaurant Owner would see.
        tabs.addTab("Restaurant", restaurantScreen);
        tabs.addTab("Rankings", rankingScreen);
        tabs.addTab("Analytics", analyticsScreen);

        this.add(tabs);
    }
}
