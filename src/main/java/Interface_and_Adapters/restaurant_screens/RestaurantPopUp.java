package Interface_and_Adapters.restaurant_screens;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewGateway;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewInputBoundary;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewInteractor;
import APP_Business_Rules.DishMenu.DishDataAccess;
import APP_Business_Rules.DishMenu.DishFileReader;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsInputBoundary;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsInteractor;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsGateway;
import APP_Business_Rules.LoadAccountInfo.PullAccountInfoController;
import APP_Business_Rules.LoadAccountInfo.PullAccountInputBoundary;
import APP_Business_Rules.LoadAccountInfo.PullAcountInteractor;
import APP_Business_Rules.login_user.AccountUserGateway;
import APP_Business_Rules.login_user.LoginUserPresenter;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Frameworks_and_Drivers.AccountUserFile;
import Frameworks_and_Drivers.ReviewFile;
import Interface_and_Adapters.CreateReviewScreen.*;
import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishScreen;
import Interface_and_Adapters.DisplayReviewsScreen.*;
import Interface_and_Adapters.Main;
import Interface_and_Adapters.TabPanel;
import Interface_and_Adapters.start_up_screens.LoginUserResponse;
import Interface_and_Adapters.start_up_screens.ProfileScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class RestaurantPopUp extends JPanel{
    /*
    Displays Restaurant information specific to the button previously clicked. Possessed ability
    to create reviews based on this Restaurant.
     */
    RestaurantController restaurantController;
    DishController dishController;
    JPanel mainScreen;

    RestaurantPopUp(JPanel mainScreen , String resName, String resCategory, String address, String starRating,
                    LoginUserResponseModel account, RestaurantController restaurantController, JPanel mainPanel, DishController dishController, int likes){
        this.restaurantController = restaurantController;
        this.dishController = dishController;
        this.mainScreen = mainScreen;

        this.setLayout(new FlowLayout());
        JPanel firstPanel = new JPanel();
        JPanel secondPanel = new JPanel();
        JLabel likeLabel = new JLabel();

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
        JButton like = new JButton("Like");
        LoginUserPresenter presenter = new LoginUserResponse();
        AccountUserGateway gateway = new AccountUserFile("./accounts.csv");
        PullAccountInputBoundary interactor = new PullAcountInteractor(account, presenter, gateway);
        PullAccountInfoController controller = new PullAccountInfoController(interactor);
        like.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUserResponseModel response = controller.updateBio(account.getUsername(), account.getBio(), account.getDate(), account.getPic(), account.getFavRestaurants(), resName);
                likeLabel.setText(Integer.toString(likes + 1));
                Main main = new Main();

                try {
                    mainScreen.add(new TabPanel(mainScreen, response), "FOURTH");
                    main.switchPanel(mainScreen, "FOURTH");

                    main.switchPanel(mainScreen, "card1");
                }catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }


        });
        backButton.addActionListener(new ActionListener() { //button brings user back into RestaurantScreen
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurantScreen resScreen = new RestaurantScreen(mainScreen, restaurantController, account, dishController, false);
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
                        mainPanel, account.getUsername(), resName);
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

        likeLabel.setText(Integer.toString(likes));

        GridBagConstraints  i= new GridBagConstraints();
        i.fill = GridBagConstraints.HORIZONTAL;
        i.weightx = 0.5;
        i.weighty = 0.2;
        i.gridx = 2;
        i.gridy = 4;
        infoPanel.add(like, i);

        GridBagConstraints  j= new GridBagConstraints();
        j.fill = GridBagConstraints.HORIZONTAL;
        j.weightx = 0.5;
        j.weighty = 0.2;
        j.gridx = 3;
        j.gridy = 4;
        infoPanel.add(likeLabel, j);

        infoPanel.setVisible(true);
        this.setVisible(true);
        firstPanel.add(infoPanel);
        this.add(firstPanel);
        //creates a new dish screen object which will serve as the clickable "menu"
        DishScreen screen = new DishScreen(dishController, resName);

        secondPanel.add(screen);
        secondPanel.add(backButton);
        this.add(secondPanel);
    }
    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }



}
