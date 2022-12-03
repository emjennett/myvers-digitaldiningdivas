package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.RestaurantUseCase.*;
import APP_Business_Rules.RestaurantUseCase.RestaurantFormatted;

import APP_Business_Rules.login_user.AccountUserGateway;
import APP_Business_Rules.login_user.LoginUserGatewayModel;

import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.*;

import javax.swing.*;



public class TabPanel extends JPanel{
    private JPanel mainPanel;
    private LoginUserResponseModel account;

    public TabPanel(JPanel mainPanel, LoginUserResponseModel account) {
        this.mainPanel = mainPanel;
        this.account = account;

        JTabbedPane tabs = new JTabbedPane();

        RestaurantDataAccess res;
        res = new RestaurantFileReader("src/main/java/Frameworks_and_Drivers/Restaurant.csv");


        RestaurantPresenter presenter = new RestaurantFormatted();
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        RestaurantInputBoundary interactor = new RestaurantInteractor(
                res, presenter, restaurantFactory);
        RestaurantController restaurantController = new RestaurantController(
                interactor);

        ProfileScreen welcomeScreen = new ProfileScreen(account);
        // will add new ProfileScreen(Account)
        RestaurantScreen restaurantScreen = new RestaurantScreen(restaurantController);

        AnalyticsScreen analyticsScreen = new AnalyticsScreen();
        RankingScreen rankingScreen = new RankingScreen();

        //adds windows with labels to tab layout. This is an example of what a Restaurant Owner would see.
        tabs.addTab("Home", welcomeScreen);
        tabs.addTab("Restaurant", restaurantScreen);
        tabs.addTab("Rankings", rankingScreen);
        tabs.addTab("Analytics", analyticsScreen);

        this.add(tabs);
        //JOptionPane.showMessageDialog(this, "Welcome " + account.getUsername() + "!");
    }
}
