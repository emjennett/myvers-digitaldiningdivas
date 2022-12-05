package Interface_and_Adapters;


import APP_Business_Rules.DishMenu.DishFileReader;
import APP_Business_Rules.RestaurantUseCase.RestaurantFileReader;
import APP_Business_Rules.SearchUseCase.SearchDishUseCase;
import APP_Business_Rules.SearchUseCase.SearchRestaurantUseCase;
import APP_Business_Rules.create_user.*;
import APP_Business_Rules.login_user.*;
import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.AccountUserFile;
import Frameworks_and_Drivers.UserFile;
import Frameworks_and_Drivers.View;
import Interface_and_Adapters.StartUpScreens.*;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{

    public static void main(String[] args){
        UserFile userFile = new UserFile("users.csv"); //User file instance
        AccountUserFile accountUserFile = new AccountUserFile("accounts.csv"); // Account user file instance
        AccountFactory accountFactory = new AccountFactory(); // Account factory instance
        LoginUserResponse loginUserResponse = new LoginUserResponse(); // Login user response instance
        LoginUserInteractor loginUserInteractor = new LoginUserInteractor(userFile, accountUserFile, accountFactory, loginUserResponse); // Login user interactor instance
        LoginUserController loginUserController = new LoginUserController(loginUserInteractor); // Login user controller instance
        CreateUserResponse createUserResponse = new CreateUserResponse();
        CreateUserInteractor createUserInteractor = new CreateUserInteractor(userFile, accountFactory, createUserResponse);
        CreateUserController createUserController = new CreateUserController(createUserInteractor);
        RestaurantFileReader restaurantFileReader = new RestaurantFileReader("src/main/java/Frameworks_and_Drivers/Restaurant.csv");
        DishFileReader dishFileReader = new DishFileReader("src/main/java/Frameworks_and_Drivers/Dishes.csv");
        SearchPresenter searchPresenter = new SearchPresenter();
        SearchRestaurantUseCase searchRestaurantUseCase = new SearchRestaurantUseCase(searchPresenter,restaurantFileReader);
        SearchDishUseCase searchDishUseCase = new SearchDishUseCase(searchPresenter, dishFileReader);
        SearchController searchController = new SearchController(searchDishUseCase, searchRestaurantUseCase);
        View view = new View(loginUserController, createUserController, searchController);
        searchPresenter.setView(view);
        JFrame frame = new JFrame("view");
        frame.setContentPane(view.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
