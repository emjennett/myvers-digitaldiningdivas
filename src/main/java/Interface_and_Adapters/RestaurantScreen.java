package Interface_and_Adapters;

import APP_Business_Rules.RestaurantUseCase.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.List;

public class RestaurantScreen extends JPanel implements ActionListener {
    /* Displays Restaurant information to the user.
     */
    RestaurantController restaurantController;

    public RestaurantScreen(RestaurantController restaurantController) throws IOException {
        CardLayout cards = new CardLayout();
        this.setLayout(cards);
        JPanel subPanel = new JPanel(); //panel for button grid

        subPanel.setLayout(new GridLayout(0, 1, 10, 10));
        subPanel.setBorder(new EmptyBorder(20,50,40,50));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        this.restaurantController = restaurantController;

        RestaurantDataAccess restaurants;
        restaurants = new RestaurantFileReader("C:\\Users\\Emily\\IdeaProjects\\course-project-digitaldiningdivas\\src\\main\\java\\Frameworks_and_Drivers\\Restaurant.csv");

        for(List<String> element: restaurants.getRes("C:\\Users\\Emily\\IdeaProjects\\course-project-digitaldiningdivas\\src\\main\\java\\Frameworks_and_Drivers\\Restaurant.csv")){
            JButton button = new JButton(element.get(0));
            button.setBorderPainted(false);
            subPanel.add(button, c);

            button.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                        //opens restaurant window with jbuttons from "home" screen
                {
                    RestaurantPopUp popUp = new RestaurantPopUp(element.get(0), element.get(1), element.get(2), element.get(3));
                    RestaurantScreen.this.add(popUp, "card1");
                    GridBagConstraints c = new GridBagConstraints();
                    JButton backButton = new JButton("Back");
                    popUp.add(backButton);
                    backButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            CardLayout cardLayout = (CardLayout) RestaurantScreen.this.getLayout();
                            cardLayout.first(RestaurantScreen.this); //returns to first screen by button click
                        }

                    });
                    cards.show(RestaurantScreen.this, "card1");

                }
            });
            c.gridy+=1;
        }
        JScrollPane scroller = new JScrollPane(subPanel);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scroller);


    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
