package Interface_and_Adapters.SearchScreen;
import Interface_and_Adapters.UI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchScreen implements UI {
    String[] header = { "Name", "Category", "Address", "Rating" };
    private JTabbedPane tabbedPane;
    private JPanel ResearchPanel;
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
    private String currentUser; //Variable that represents current user
    private SearchController searchController;

    public SearchScreen(SearchController searchController, JPanel mainPanel, JPanel reviewPanel){
        this.searchController = searchController;

        //Show the search panel
        CardLayout card = (CardLayout) ResearchPanel.getLayout();
        card.show(ResearchPanel, "appCard");

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

        //Add listener to rows of restaurant table to display reviews
        restaurantTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex = restaurantTable.getSelectedRow();
                if(rowIndex != -1){
                    //switch to review panel
                }
            }
        });

        //Add listener to rows of dish table to display reviews
        dishTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex = dishTable.getSelectedRow();
                if(rowIndex != -1){
                    //switch to review panel
                }
            }
        });
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

    //Default Restaurant and dish table
    public void defaultTable(){
        //Setting up default data displayed of the search tab
        searchController.Search("", "Restaurant","All",0);
        searchController.Search("", "Dish","All",0);
    }

    public JPanel getResearchPanel() {
        return ResearchPanel;
    }
}
