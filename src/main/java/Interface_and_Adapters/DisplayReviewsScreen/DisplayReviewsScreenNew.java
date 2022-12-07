package Interface_and_Adapters.DisplayReviewsScreen;

import APP_Business_Rules.RestaurantUseCase.RestaurantFileReader;
import Entities.Review;
import Frameworks_and_Drivers.ReviewFile;
import Interface_and_Adapters.restaurant_screens.RestaurantPopUp;
import APP_Business_Rules.DisplayReviewsUseCase.*;
import Interface_and_Adapters.restaurant_screens.RestaurantScreen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DisplayReviewsScreenNew extends JPanel implements ActionListener{

    DisplayReviewsController displayReviewsController;

    public DisplayReviewsScreenNew(DisplayReviewsController displayReviewsController,
                                   JPanel outerPanel, String resOrDish) {
        this.displayReviewsController = displayReviewsController;

        JPanel subPanel = new JPanel(); //panel for button grid

        subPanel.setLayout(new GridLayout(0, 1, 10, 10));
        subPanel.setBorder(new EmptyBorder(20, 50, 40, 50));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() { //button brings user back into RestaurantScreen
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayReviewsScreenNew.this.switchPanel(outerPanel, "card1"); //returns to first screen by button click
            }

        });
        this.add(backButton);

        DisplayReviewsGateway reviewListReader;
        reviewListReader = new ReviewFile();
        List<Review> revList = reviewListReader.retrieveReviews(resOrDish);
        for (Review review : revList) {
            JButton button = new JButton(review.getAuthor() + ", " + review.getRatingString());
            button.setBorderPainted(false);
            subPanel.add(button, c);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                //opens restaurant window with jbuttons from "home" screen
                {
                    DisplayReviewsPopUp popUp = new DisplayReviewsPopUp(review.getAuthor(), review.getRatingString(),
                            review.getReview(), review.getReviewed(), review.getCreatedOn(),
                            displayReviewsController, outerPanel);
                    outerPanel.add(popUp, "details");
                    CardLayout card = (CardLayout) (outerPanel.getLayout());
                    card.show(outerPanel, "details");

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

