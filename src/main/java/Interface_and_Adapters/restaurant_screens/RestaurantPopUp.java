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

        this.setLayout(new FlowLayout());
        JPanel firstPanel = new JPanel();
        JPanel secondPanel = new JPanel();

        BoxLayout boxLayout1 = new BoxLayout(firstPanel, BoxLayout.Y_AXIS);
        firstPanel.setLayout(boxLayout1);
        BoxLayout boxLayout2 = new BoxLayout(secondPanel, BoxLayout.Y_AXIS);
        secondPanel.setLayout(boxLayout2);

        JPanel infoPanel = new JPanel();
        infoPanel.setSize(200, 70);

        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel restaurantLabel = new JLabel(resName);
        int starCount = Integer.parseInt(starRating); //turns star string into integer

        for (int i = 0; i < starCount; i++) { //creates multiple stars according to starCount
            c.fill = GridBagConstraints.CENTER;
            c.weightx = 0.5;
            c.weighty = 1.0;
            c.gridx = 1;
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

        restaurantLabel.setFont(new Font("Sans Serif", Font.BOLD, 40));
        GridBagConstraints d = new GridBagConstraints();
        d.fill = GridBagConstraints.HORIZONTAL;
        d.weightx = 0;
        d.weighty = 1.0;
        d.gridx = 1;
        d.gridy = 0;
        infoPanel.add(restaurantLabel, d);
        GridBagConstraints e = new GridBagConstraints();
        JLabel category = new JLabel(resCategory);
        e.fill = GridBagConstraints.HORIZONTAL;
        e.weightx = 0.5;
        e.weighty = 0.5;
        e.gridx = 1;
        e.gridy = 4;
        infoPanel.add(category, e);
        GridBagConstraints f = new GridBagConstraints();
        JLabel addressLabel = new JLabel(address);
        f.fill = GridBagConstraints.HORIZONTAL;
        f.weightx = 0.5;
        f.weighty = 0.5;
        f.gridx = 1;
        f.gridy = 2;
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

        GridBagConstraints  g= new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;
        g.weightx = 0.5;
        g.weighty = 0.2;
        g.gridx = 0;
        g.gridy = 3;
        infoPanel.add(ReviewsButton, g);

        GridBagConstraints  h= new GridBagConstraints();
        h.fill = GridBagConstraints.HORIZONTAL;
        h.weightx = 0.5;
        h.weighty = 0.2;
        h.gridx = 2;
        h.gridy = 3;
        infoPanel.add(resReviewsButton, h);

        infoPanel.setVisible(true);
        this.setVisible(true);
        firstPanel.add(infoPanel);
        this.add(firstPanel);
        //creates a new dish screen object which will serve as the clickable "menu"
        DishScreen screen = new DishScreen(dishController, resName);
        screen.setPreferredSize(new Dimension(600, 500));

        secondPanel.add(screen);
        secondPanel.add(backButton);
        this.add(secondPanel);
        this.setPreferredSize(new Dimension(1000, 570));
    }
    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }



}
