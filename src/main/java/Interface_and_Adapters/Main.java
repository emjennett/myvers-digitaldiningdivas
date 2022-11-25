package Interface_and_Adapters;

import APP_Business_Rules.RestaurantUseCase.*;
import APP_Business_Rules.RestaurantUseCase.RestaurantFormatted;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
        Adds screens to a JTabbedPane.
         */


        JFrame frame = new JFrame("Digital Dining Divas");
        JTabbedPane tabs = new JTabbedPane();

        RestaurantDataAccess res;
        res = new RestaurantFileReader("src/main/java/Frameworks_and_Drivers/Restaurant.csv");


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



        //adds tab layout to jFrame
        frame.getContentPane().add(tabs);

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }



}
