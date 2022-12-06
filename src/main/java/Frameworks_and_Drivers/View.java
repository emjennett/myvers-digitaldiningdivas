package Frameworks_and_Drivers;

import APP_Business_Rules.RestaurantUseCase.RestaurantDataAccess;
import APP_Business_Rules.RestaurantUseCase.RestaurantFileReader;
import APP_Business_Rules.create_user.CreateUserController;
import APP_Business_Rules.login_user.LoginUserController;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.MenuController;
import Interface_and_Adapters.SearchController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class View implements UI {
    RestaurantDataAccess restaurants = new RestaurantFileReader("src/main/java/Frameworks_and_Drivers/Restaurant.csv");
    List<List<String>> rec = restaurants.getRes();
    String[] header = { "Name", "Category", "Address", "Rating" };
    private JTabbedPane tabbedPane;
    private JPanel mainPanel;
    private JPanel Restaurant;
    private JPanel Dish;
    private JTextField restaurantSearchTextField;
    private JButton restaurantSearchButton;
    private JTable restaurantTable;
    private JPanel restaurantFilters;
    private JComboBox restaurantCategoryComboBox;
    private JLabel restaurantCategoryLabel;
    private JLabel restaurantRatingLabel;
    private JSpinner restaurantRatingSpinner;
    private JTextField dishSearchTextField;
    private JButton dishSearchButton;
    private JTable dishTable;
    private JPanel dishfilters;
    private JComboBox dishCategoryComboBox;
    private JSpinner dishRatingSpinner;
    private JLabel dishCategoryLabel;
    private JLabel dishRatingLabel;
    private JPanel welcomePanel;
    private JLabel titleLabel;
    private JPanel loginAndRegistrationPanel;
    private JPanel loginPanel;
    private JPanel registrationPanel;
    private JTextField loginUsernameTextField;
    private JLabel loginLabel;
    private JLabel loginUsernameLabel;
    private JLabel loginPasswordLabel;
    private JPasswordField loginPasswordField;
    private JTextField registerUsernameTextField;
    private JPasswordField registerPasswordField;
    private JPasswordField registerConfirmPasswordField;
    private JButton loginButton;
    private JLabel registerLabel;
    private JLabel registerUsernamelabel;
    private JLabel registerPasswordLable;
    private JLabel registerConfirmPasswordLabel;
    private JButton registerButton;
    private JPanel restaurantPanel;
    private JTable menuTable;
    private JLabel restaurantNameLabel;
    private JPanel reviewDishPanel;
    private JTable reviewsTable;
    private JLabel dishNameLabel;
    private JSpinner ratingSpinner;
    private JTextArea reviewTextArea;
    private JButton reviewButton;
    private JLabel reviewLabel;
    private JLabel reviewsLabel;
    private JPanel addReviewPanel;
    private JButton menuBackButton;
    private LoginUserResponseModel currentUser; //Variable that represents current user
    private LoginUserController loginUserController;
    private CreateUserController createUserController;
    private SearchController searchController;

    public View(LoginUserController loginUserController, CreateUserController createUserController, SearchController searchController, MenuController menuController){
        //Show the welcome panel first
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "welcomeCard");

        //Login button listener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    currentUser = loginUserController.login(loginUsernameTextField.getText(), loginPasswordField.getText());
                    card.show(mainPanel, "appCard");
                    clearWelcomePageTextFields();
                    //Show all restaurants
                    searchController.Search("", "Restaurant", (String) restaurantCategoryComboBox.getSelectedItem(), (int) restaurantRatingSpinner.getValue());

                    //Show all dishes
                    searchController.Search("", "Dish", (String) dishCategoryComboBox.getSelectedItem(), (int) dishRatingSpinner.getValue());

                    //Set up categories name
                    setUpCategories();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(welcomePanel, ex.getMessage());
                }
            }
        });

        //Register button listener
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String loginMessage = createUserController.create(registerUsernameTextField.getText(), registerPasswordField.getText(), registerConfirmPasswordField.getText()).getLogin();
                    JOptionPane.showMessageDialog(welcomePanel, loginMessage);
                    currentUser = loginUserController.login(registerUsernameTextField.getText(), registerPasswordField.getText());
                    card.show(mainPanel, "appCard");
                    clearWelcomePageTextFields();
                    //Show all restaurants
                    searchController.Search("", "Restaurant", (String) restaurantCategoryComboBox.getSelectedItem(), (int) restaurantRatingSpinner.getValue());

                    //Show all dishes
                    searchController.Search("", "Dish", (String) dishCategoryComboBox.getSelectedItem(), (int) dishRatingSpinner.getValue());

                    //Set up categories name
                    setUpCategories();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(welcomePanel, ex.getMessage());
                }
            }
        });

        //Search buttons listeners
        dishSearchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                searchController.Search(dishSearchTextField.getText(), "Dish", (String) dishCategoryComboBox.getSelectedItem(), (int) dishRatingSpinner.getValue());
            }
        });

        restaurantSearchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                searchController.Search(restaurantSearchTextField.getText(), "Restaurant", (String) restaurantCategoryComboBox.getSelectedItem(), (int) restaurantRatingSpinner.getValue());
            }
        });

        //Set up categories name
        setUpCategories();

        //Add listener to rows of restauarant table to display restaurant menu
        restaurantTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!(restaurantTable.getSelectedRow() == -1)){
                    int rowIndex = restaurantTable.getSelectedRow();
                    card.show(mainPanel, "restaurantCard");
                    restaurantNameLabel.setText((String) restaurantTable.getModel().getValueAt(rowIndex, 0));
                    menuController.generateMenu(restaurantNameLabel.getText());
                    restaurantTable.getSelectionModel().clearSelection();
                }
            }
        });

        //Menu card back button
        menuBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(mainPanel, "appCard");
            }
        });
    }

    //Clear text fields in the welcome page
    public void clearWelcomePageTextFields(){
        loginUsernameTextField.setText("");
        loginPasswordField.setText("");
        registerUsernameTextField.setText("");
        registerPasswordField.setText("");
        registerConfirmPasswordField.setText("");
    }

    //Set up the category items
    public void setUpCategories(){
        dishCategoryComboBox.addItem("All");
        restaurantCategoryComboBox.addItem("All");
        List<String> record = new ArrayList<>();
        for (int i = 0; i < restaurantTable.getModel().getRowCount(); i++){
            if(!record.contains(restaurantTable.getModel().getValueAt(i, 1))){
                record.add((String) restaurantTable.getModel().getValueAt(i, 1));
                restaurantCategoryComboBox.addItem(restaurantTable.getModel().getValueAt(i, 1));
            }
        }
        for (int i = 0; i < dishTable.getModel().getRowCount(); i++){
            if(!record.contains(dishTable.getModel().getValueAt(i, 3))){
                record.add((String) dishTable.getModel().getValueAt(i, 3));
                dishCategoryComboBox.addItem(dishTable.getModel().getValueAt(i, 3));
            }
        }
    }

    //Change the Restaurant table
    public void updateRestaurantTable(String[][] data){
        DefaultTableModel model = new DefaultTableModel(header,0);
        restaurantTable.setModel(model);
        for(String[] d: data){
            model.addRow(d);
        }
    }

    //Change Dish table
    @Override
    public void updateDishTable(String[][] data) {
        DefaultTableModel model = new DefaultTableModel(header,0);
        dishTable.setModel(model);
        for(String[] d: data){
            model.addRow(d);
        }
    }
    //Genereate restaurant menu
    @Override
    public void updateMenuTable(String[][] data) {
        DefaultTableModel model = new DefaultTableModel(header,0);
        menuTable.setModel(model);
        for(String[] d: data){
            model.addRow(d);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
