package Interface_and_Adapters;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        /*
        Adds screens to a JTabbedPane.
         */

        JFrame frame = new JFrame("Digital Dining Divas");
        JTabbedPane tabs = new JTabbedPane();

        RestaurantScreen restaurantScreen = new RestaurantScreen();
        AnalyticsScreen analyticsScreen = new AnalyticsScreen();
        RankingScreen rankingScreen = new RankingScreen();

        //instantiate presenters, input boundaries, controllers, and any other windows here

        //adds windows with labels to tab layout
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
