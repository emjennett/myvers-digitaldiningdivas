package Interface_and_Adapters.restaurant_screens;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewGateway;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewInputBoundary;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewInteractor;
import APP_Business_Rules.DishMenu.DishDataAccess;
import APP_Business_Rules.DishMenu.DishFileReader;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsInputBoundary;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsInteractor;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsGateway;
import Frameworks_and_Drivers.ReviewFile;
import Interface_and_Adapters.CreateReviewScreen.*;
import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishScreen;
import Interface_and_Adapters.DisplayReviewsScreen.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RestaurantPopUp extends JPanel{
    /*
    Displays Restaurant information specific to the button previously clicked. Possessed ability
    to create reviews based on this Restaurant.
     */
    RestaurantController restaurantController;
    DishController dishController;

    RestaurantPopUp(String resName, String resCategory, String address, String starRating,
                    String account, RestaurantController restaurantController, JPanel mainPanel, DishController dishController){
        this.restaurantController = restaurantController;
        this.dishController = dishController;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel name = new JLabel(resName);
        int starCount = Integer.parseInt(starRating); //turns star string into integer

        for (int i = 0; i < starCount; i++) { //creates multiple stars according to starCount
            c.fill = GridBagConstraints.CENTER;
            c.weightx = 0.5;
            c.weighty = 1.0;
            c.gridx = 3;
            c.gridy = 1;
            JLabel imageLabel = new JLabel();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("./19-star-png-image.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            imageLabel.setIcon(imageIcon);
            imageLabel.setHorizontalTextPosition(SwingConstants.LEFT);
            infoPanel.add(imageLabel, c);
            imageLabel.setText(imageLabel.getText()+ "Michelin Stars:");

        }


        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() { //button brings user back into RestaurantScreen
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurantScreen resScreen = new RestaurantScreen(restaurantController, account, dishController);
                resScreen.switchPanel(mainPanel, "one"); //returns to first screen by button click
            }

        });


        name.setFont(new Font("Sans Serif", Font.BOLD, 20));
        GridBagConstraints d = new GridBagConstraints();
        d.fill = GridBagConstraints.HORIZONTAL;
        d.weightx = 0.5;
        d.weighty = 1.0;
        d.gridx = 2;
        d.gridy = 0;
        infoPanel.add(name, d);
        GridBagConstraints e = new GridBagConstraints();
        JLabel category = new JLabel(resCategory);
        e.fill = GridBagConstraints.HORIZONTAL;
        e.weightx = 0.5;
        e.weighty = 1.0;
        e.gridx = 2;
        e.gridy = 1;
        infoPanel.add(category, e);
        GridBagConstraints f = new GridBagConstraints();
        JLabel addressLabel = new JLabel(address);
        f.fill = GridBagConstraints.HORIZONTAL;
        f.weightx = 0.5;
        f.weighty = 1.0;
        f.gridx = 1;
        f.gridy = 1;
        infoPanel.add(addressLabel, f);

        JButton resReviewsButton = new JButton("See reviews"); //Allows user to add review for this Restaurant
        resReviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayReviewsGateway revGate = new ReviewFile();
                DisplayReviewsPresenter disRev = new DisplayReviewsFormatted();
                DisplayReviewsInputBoundary inBoundRev = new DisplayReviewsInteractor(revGate, disRev);
                DisplayReviewsController disRevController = new DisplayReviewsController(inBoundRev);
                DisplayReviewsScreenNew seeReviews = new DisplayReviewsScreenNew(disRevController,
                        mainPanel, resName);
                mainPanel.add(seeReviews, "seeReviews");
                switchPanel(mainPanel, "seeReviews");

            }
        });
        infoPanel.add(resReviewsButton);
        this.setVisible(true);

        JButton ReviewsButton = new JButton("new review"); //Allows user to add review for this Restaurant
        ReviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateReviewGateway revGate = new ReviewFile();
                CreateReviewPresenter disRev = new CreateReviewFormatted();
                CreateReviewInputBoundary inBoundRev = new CreateReviewInteractor(revGate, disRev);
                CreateReviewController disRevController = new CreateReviewController(inBoundRev);
                CreateReviewScreenNew writeReview = new CreateReviewScreenNew(disRevController,
                        mainPanel, account, resName);
                mainPanel.add(writeReview, "writeReview");
                switchPanel(mainPanel, "writeReview");

            }
        });
        infoPanel.add(ReviewsButton);
        infoPanel.setVisible(true);
        this.setVisible(true);
        infoPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        this.add(infoPanel);
        DishScreen screen = new DishScreen(dishController, resName);
        screen.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        this.add(screen, "dishPopUp");

        backButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        infoPanel.add(backButton);
        this.setPreferredSize(new Dimension(1000, 1000));
    }
    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }



}
