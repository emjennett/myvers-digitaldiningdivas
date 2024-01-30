package Interface_and_Adapters.start_up_screens;

import APP_Business_Rules.DishMenu.*;
import APP_Business_Rules.RestaurantUseCase.*;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishFormatted;
import Interface_and_Adapters.DishMenuScreens.DishPresenter;
import Interface_and_Adapters.Main;
import Interface_and_Adapters.TabPanel;
import Interface_and_Adapters.restaurant_screens.RestaurantController;
import Interface_and_Adapters.restaurant_screens.RestaurantFormatted;
import Interface_and_Adapters.restaurant_screens.RestaurantPresenter;
import Interface_and_Adapters.restaurant_screens.RestaurantScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginScreen extends JPanel {
    private final JPanel mainPanel;
    private JButton cancel;
    private JButton login;
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);

    LoginUserController controller;

    public LoginScreen(LoginUserController controller, JPanel mainPanel) {
        this.controller = controller;
        this.mainPanel = mainPanel;

        this.add(Box.createVerticalGlue());
        JLabel title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelHelper usernameBox = new LabelHelper(new JLabel("Username"), username);
        LabelHelper passwordBox = new LabelHelper(new JLabel("Password"), password);

        JPanel buttons = new JPanel();
        buttons.add(createLoginButton());
        buttons.add(createCancelButton());


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernameBox);
        this.add(passwordBox);
        this.add(buttons);
        this.add(Box.createVerticalGlue());
    }

    private JButton createCancelButton() {
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.switchPanel(mainPanel, "FIRST");
            }

        });
        return cancel;

    }

    private JButton createLoginButton() {
        login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
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

                    LoginUserResponseModel account = controller.login(
                            username.getText(), String.valueOf(password.getPassword()));

                    java.util.List<String> resList = new java.util.ArrayList<String>();
                    RestaurantResponseModel resResponse = restaurantController.updateRestaurant(" ", " ", " ", 0, resList, null);

                    RestaurantScreen resScreen = new RestaurantScreen(mainPanel, resResponse, restaurantController, account, dishController, true);
                    ProfileScreen profileScreen = new ProfileScreen(account, mainPanel,restaurantController, resScreen);

                    Main main = new Main();
                    mainPanel.add(new TabPanel(mainPanel, resScreen, profileScreen), "FOURTH");
                    main.switchPanel(mainPanel, "FOURTH");


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(LoginScreen.this, ex.getMessage());
                }
            }

        });
        return login;

    }
}

