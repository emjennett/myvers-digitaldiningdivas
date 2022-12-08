package Interface_and_Adapters;


import APP_Business_Rules.DishMenu.DishFileReader;
import APP_Business_Rules.RestaurantUseCase.RestaurantFileReader;
import APP_Business_Rules.SearchUseCase.SearchDishUseCase;
import APP_Business_Rules.SearchUseCase.SearchRestaurantUseCase;
import APP_Business_Rules.create_user.*;

import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.StartUpScreens.CreateUserResponse;
import Interface_and_Adapters.StartUpScreens.SignUpScreen;
import Interface_and_Adapters.StartUpScreens.StartUpScreen;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{

    public Main() {
        JPanel mainPanel = new JPanel();


        CreateUserGateway user;
        user = new UserFile("./users.csv");
        CreateUserPresenter presenter = new CreateUserResponse();
        UserFactory userFactory = new AccountFactory();
        CreateUserInputBoundary interactor = new CreateUserInteractor(
                user, userFactory, presenter);
        CreateUserController controller = new CreateUserController(interactor);

        //Initializing file readers
        DishFileReader dishFileReader = new DishFileReader("src/main/java/Frameworks_and_Drivers/dish.csv");
        RestaurantFileReader restaurantFileReader = new RestaurantFileReader("src/main/java/Frameworks_and_Drivers/Restaurant.csv");

        //Initializing classes that contribute to the search Usecase
        SearchPresenter searchPresenter = new SearchPresenter();
        SearchDishUseCase searchDishUseCase = new SearchDishUseCase(searchPresenter, dishFileReader);
        SearchRestaurantUseCase searchRestaurantUseCase = new SearchRestaurantUseCase(searchPresenter, restaurantFileReader);
        SearchController searchController = new SearchController(searchDishUseCase, searchRestaurantUseCase);
        SearchScreen searchScreen = new SearchScreen(searchController, mainPanel, null);
        searchPresenter.setView(searchScreen);
        //

        this.setTitle("Digital Dining Divas");
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        mainPanel.setLayout(new CardLayout());
        mainPanel.add(new StartUpScreen(mainPanel), "FIRST");
        mainPanel.add(new SignUpScreen(controller, mainPanel), "SECOND");
        mainPanel.add(searchScreen.getResearchPanel(), "FOURTH");
        this.setContentPane(mainPanel);
        switchPanel(mainPanel, "FOURTH");

    }

    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}
