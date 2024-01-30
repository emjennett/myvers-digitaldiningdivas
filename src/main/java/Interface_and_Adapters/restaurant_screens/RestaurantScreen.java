package Interface_and_Adapters.restaurant_screens;

import APP_Business_Rules.RestaurantUseCase.*;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.DishMenuScreens.DishController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestaurantScreen extends JPanel {
    /* Displays Restaurant information to the user.
     */
    RestaurantController restaurantController;
    LoginUserResponseModel account;
    DishController dishController;
    JPanel mainScreen;
    RestaurantResponseModel resResponse;
    public RestaurantScreen(JPanel mainScreen, RestaurantResponseModel resResponse, RestaurantController restaurantController, LoginUserResponseModel account, DishController dishController, boolean favourites) {
        this.restaurantController = restaurantController;
        this.account = account;
        this.dishController = dishController;
        this.mainScreen = mainScreen;
        this.resResponse = resResponse;

        //panel to switch between restaurant screen and restaurant popup
        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new CardLayout());
        JPanel subPanel = new JPanel(); //panel for button grid

        subPanel.setLayout(new GridLayout(0, 1, 10, 10));
        subPanel.setBorder(new EmptyBorder(20, 50, 40, 50));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        RestaurantDataAccess restaurants;
        restaurants = new RestaurantFileReader("./Restaurant.csv");
        Map<String, RestaurantGatewayModel> allRes = restaurants.getAllRes();
        List<List<String>> allResList = modelToList(allRes);

        //creates a list of buttons that contain all restaurant names
        List<String> allNames = new ArrayList<>();
        for(List<String> element : allResList){
            allNames.add(element.get(0));
        }

        //if we are to display a popup with only favourites, only select those out of all restaurants
        if (favourites == true) {
            allNames.retainAll(account.getFavRestaurants());
        }
        List<List<String>>  displayRestaurants = new ArrayList<>();
        for(List<String> element: allResList){
            if(allNames.contains(element.get(0))){
                displayRestaurants.add(element);
            }
        }

        for (List<String> element : allResList) {
                // element.get(0) is a restaurant name
            JButton button = new JButton(element.get(0));
            button.setPreferredSize(new Dimension(40, 40));
            button.setBorderPainted(false);
            subPanel.add(button, c);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                //opens restaurant popup with jbuttons on the restaurant screen
                {

                    RestaurantPopUp popUp = new RestaurantPopUp(mainScreen, resResponse, element.get(0), element.get(1),
                            element.get(2), element.get(3), account, restaurantController, outerPanel, dishController, Integer.parseInt(element.get(4)), favourites);

                    outerPanel.add(popUp, "card1");
                    switchPanel(outerPanel, "card1");

                }
            });
            c.gridy += 1;
        }

        JScrollPane scroller = new JScrollPane(subPanel);
        scroller.setPreferredSize(new Dimension(1200, 700));
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        outerPanel.add(scroller, "one");
        this.add(outerPanel);
    }

    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

    public List<List<String>> modelToList(Map<String, RestaurantGatewayModel> model){
        List<List<String>> resList = new ArrayList<>();
        //iterates through each mapping. Keys are ResName, and values are the entire restaurant
        for(Map.Entry<String, RestaurantGatewayModel> element: model.entrySet()){
            List<String> restaurantRep = new ArrayList<>();
            restaurantRep.add(element.getValue().getResName());
            restaurantRep.add(element.getValue().getResCategory());
            restaurantRep.add(element.getValue().getResLocation());
            String stars = Integer.toString(element.getValue().getStars());
            restaurantRep.add(stars);
            String likes = Integer.toString(element.getValue().getLikeList().size());
            restaurantRep.add(likes);
            resList.add(restaurantRep);
        }

        return resList;
    }

}