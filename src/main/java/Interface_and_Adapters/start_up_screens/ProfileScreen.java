package Interface_and_Adapters.start_up_screens;


import APP_Business_Rules.DishMenu.*;
import APP_Business_Rules.LoadAccountInfo.*;
import APP_Business_Rules.RestaurantUseCase.*;
import APP_Business_Rules.login_user.AccountUserGateway;
import APP_Business_Rules.login_user.LoginUserPresenter;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Frameworks_and_Drivers.AccountUserFile;
import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishFormatted;
import Interface_and_Adapters.DishMenuScreens.DishPresenter;
import Interface_and_Adapters.Main;
import Interface_and_Adapters.TabPanel;
import Interface_and_Adapters.restaurant_screens.*;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ProfileScreen extends JPanel {

    JButton btn;

    JButton backbtn;

    JButton imageBtn;

    JLabel label;
    JLabel message;
    JLabel imagee;

    JPanel firstpanel = new JPanel();


    JPanel cont = new JPanel();

    CardLayout layout = new CardLayout();

    JPanel mainscreen;
    JTextField resName = new JTextField(15);
    JTextField resCat = new JTextField(15);
    JTextField location = new JTextField(15);
    JTextField stars = new JTextField(5);
    JTextField newBio = new JTextField(25);
    JTextField newPic = new JTextField(25);
    JLabel userType = new JLabel();
    private RestaurantScreen resScreen;


    RestaurantController resController;
    LoginUserResponseModel account;

    public ProfileScreen(LoginUserResponseModel account, JPanel mainscreen, RestaurantController resController, RestaurantScreen resScreen){

        this.resController = resController;
        this.account = account;
        this.mainscreen = mainscreen;
        this.resScreen = resScreen;
        newBio.setText("Type your new bio here!");
        newPic.setText("Type in your filename");

        String bio = account.getBio();
        String user = account.getUsername();
        String url = account.getPic();



        btn = new JButton("ChangeBio");
        imageBtn = new JButton("Change profile picture");

        backbtn = new JButton("Log Out");

        label = new JLabel("Home");

        label.setFont(new Font("Arial", Font.BOLD, 20));

        imagee = DisplayImage(url);


        message = new JLabel(bio);

        btn.setVisible(false);
        newBio.setVisible(false);
        newPic.setVisible(false);
        imageBtn.setVisible(false);

        DishPresenter dishPresenter = new DishFormatted();
        DishFactory dishFactory = new DishFactory();
        DishDataAccess dish = new DishFileReader("./Dishes.csv");
        DishInputBoundary dishInteractor = new DishInteractor(dish, dishPresenter, dishFactory);
        DishController dishController = new DishController(dishInteractor);

        LoginUserPresenter presenter = new LoginUserResponse();
        AccountUserGateway gateway = new AccountUserFile("./accounts.csv");
        PullAccountInputBoundary interactor = new PullAcountInteractor(account, presenter, gateway);
        PullAccountInfoController controller = new PullAccountInfoController(interactor);

        imageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUserResponseModel response = controller.updateAccount(account.getUsername(), account.getBio(), account.getType(), account.getDate(), newPic.getText(), account.getFavRestaurants(), account.getNewRes());
                JOptionPane.showMessageDialog(ProfileScreen.this,
                        "Your pfp has successfully been updated!");
                Main main = new Main();
                imagee = DisplayImage("./"+response.getPic());

                try {
                    ProfileScreen profileScreen = new ProfileScreen(response, mainscreen, resController, resScreen);
                    mainscreen.add(new TabPanel(mainscreen, resScreen, profileScreen), "SIXTH");
                    main.switchPanel(mainscreen, "SIXTH");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                LoginUserResponseModel response = controller.updateAccount(account.getUsername(), newBio.getText(), account.getType(),account.getDate(), account.getPic(), account.getFavRestaurants(), account.getNewRes());
                JOptionPane.showMessageDialog(ProfileScreen.this,
                        "Your bio has successfully been updated!");

                Main main = new Main();
                message = new JLabel(response.getBio());
                try {
                    ProfileScreen profileScreen = new ProfileScreen(response, mainscreen, resController, resScreen);
                    mainscreen.add(new TabPanel(mainscreen, resScreen, profileScreen), "FOURTH");
                    main.switchPanel(mainscreen, "FOURTH");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            //opens restaurant window with jbuttons from "home" screen
            {
                Main main = new Main();
                main.switchPanel(mainscreen, "FIRST");

            }
        });
        JPanel resPanel = new JPanel();
        resPanel.setLayout(new BoxLayout(resPanel, BoxLayout.Y_AXIS));
        resPanel.add(Box.createVerticalGlue());
        if(account.getType().equals("owner")) {
            userType.setText("Restaurant Owner");

            JLabel createResTitle = new JLabel("Create new Restaurant");
            createResTitle.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
            LabelHelper resTitleBox = new LabelHelper(new JLabel("Input Restaurant Name"), resName);
            LabelHelper resCatBox = new LabelHelper(new JLabel("Input Restaurant Category"), resCat);
            LabelHelper resLocationBox = new LabelHelper(new JLabel("Input Restaurant Location"), location);
            LabelHelper resStarBox = new LabelHelper(new JLabel("Input Michelin Stars"), stars);

            resPanel.add(createResTitle);

            resPanel.add(resTitleBox);
            resPanel.add(resCatBox);
            resPanel.add(resLocationBox);
            resPanel.add(resStarBox);
            resPanel.add(createResButton());

        }

        //case where user is a regular user
        else{
            userType.setText("Foodie");

        }

        DefaultListModel<String> mylist = new DefaultListModel<>();
        mylist.addElement("Username: " + user);
        mylist.addElement("Bio:" + account.getBio());


        JList<String> list = new JList<>(mylist);
        list.setFont(new Font("Arial", Font.BOLD,20));
        list.setSize(100, 500);


        JPanel wrapper = new JPanel();


        label.setFont(new Font("Home", 1, 40));
        firstpanel.setLayout(new BoxLayout(firstpanel, BoxLayout.Y_AXIS));
        firstpanel.add(label);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        backbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        list.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstpanel.add(Box.createRigidArea(new Dimension(0,13)));
        firstpanel.add(Box.createVerticalGlue());

        firstpanel.add(imagee);
        imagee.setAlignmentX(Component.CENTER_ALIGNMENT);

        firstpanel.add(userType);
        userType.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstpanel.add(Box.createRigidArea(new Dimension(0,13)));
        firstpanel.add(Box.createRigidArea(new Dimension(0,13)));
        firstpanel.add(list);
        firstpanel.add(createEditProfile(firstpanel));
        firstpanel.add(newBio);
        newBio.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstpanel.add(newPic);
        newPic.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstpanel.add(Box.createRigidArea(new Dimension(0,30)));
        firstpanel.add(btn);
        firstpanel.add(imageBtn);
        imageBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

        String formattedate = account.getDate().format(formatter);
        JLabel createdOn = new JLabel("account created on: " + formattedate);
        firstpanel.add(createdOn);
        createdOn.setAlignmentX(Component.CENTER_ALIGNMENT);

        firstpanel.add(Box.createRigidArea(new Dimension(0,30)));
        firstpanel.add(backbtn);
        RestaurantFileReader res = new RestaurantFileReader("./Restaurant.csv");
        RestaurantPresenter respresenter = new RestaurantFormatted();
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        RestaurantInputBoundary resinteractor = new RestaurantInteractor(
                res, respresenter, restaurantFactory);
        RestaurantController restaurantController = new RestaurantController(
                resinteractor);
        wrapper.setLayout(new BorderLayout(20, 20));
        java.util.List<String> resList2 = new java.util.ArrayList<String>();
        RestaurantResponseModel resResponse = restaurantController.updateRestaurant(" ", " ", " ", 0, resList2, null);

        JPanel wrapper2 = new JPanel(); //jpanel wrapper that holds label & restaurant favourites
        wrapper2.setLayout(new BoxLayout(wrapper2, BoxLayout.Y_AXIS));

        JLabel favLabel = new JLabel("My Favs"); //label for resScreen2
        favLabel.setFont(new Font("Arial", 1, 25));
        wrapper2.add(favLabel);
        favLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel resScreen2 = new RestaurantScreen(mainscreen, resResponse, restaurantController, account, dishController, true);
        resScreen2.setPreferredSize(new Dimension(500, 700));

        JScrollPane scroller = new JScrollPane(resScreen2);
        scroller.setPreferredSize(new Dimension(600, 400));
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        wrapper2.add(scroller);
        if(account.getType().equals("owner")){
            wrapper2.add(resPanel);
        }

        wrapper2.setPreferredSize(new Dimension(600, 600));

        firstpanel.setPreferredSize(new Dimension(600, 500));

        wrapper.add(wrapper2, BorderLayout.EAST);
        wrapper.add(firstpanel, BorderLayout.WEST);

        cont.setLayout(layout);
        cont.add(wrapper, "1");
        this.add(cont);


    }

    private JLabel DisplayImage(String url) {
        JLabel imagee = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
        imagee.setIcon(imageIcon);
        return imagee;
    }

    private JButton createEditProfile(JPanel panel){
        JButton editProfile = new JButton("Edit Profile");
        editProfile.setAlignmentX(Component.CENTER_ALIGNMENT);
        editProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setVisible(true);
                newBio.setVisible(true);
                newPic.setVisible(true);
                imageBtn.setVisible(true);
                editProfile.setVisible(false);
                panel.add(createCancelButton(editProfile));
            }
        });
        return editProfile;
    }

    private JButton createCancelButton(JButton editProfile){
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setVisible(false);
                newBio.setVisible(false);
                newPic.setVisible(false);
                imageBtn.setVisible(false);
                editProfile.setVisible(true);
                cancelButton.setVisible(false);
            }
        });
        return cancelButton;
    }

    private JButton createResButton() {
        JButton newRes = new JButton("Create New Restaurant");
        newRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DishPresenter dishPresenter = new DishFormatted();
                DishFactory dishFactory = new DishFactory();
                DishDataAccess dish = new DishFileReader("./Dishes.csv");
                DishInputBoundary dishInteractor = new DishInteractor(dish, dishPresenter, dishFactory);
                DishController dishController = new DishController(dishInteractor);

                java.util.List<String> resList = new java.util.ArrayList<String>();
                RestaurantResponseModel newRes = resController.updateRestaurant(resName.getText(), resCat.getText(), location.getText(), Integer.parseInt(stars.getText()), resList, null);
                JOptionPane.showMessageDialog(ProfileScreen.this,
                        "Your restaurant " + resName.getText() + " has successfully been created!");

                Main main = new Main();
                try {
                    RestaurantScreen resScreen = new RestaurantScreen(mainscreen, newRes, resController, account, dishController, false);
                    mainscreen.add(new TabPanel(mainscreen, resScreen, ProfileScreen.this), "FOURTH");
                    main.switchPanel(mainscreen, "FOURTH");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        return newRes;
    }


    /**
     * switchPanel:
     * method that changes the current Jpanel
     *
     * @param container the current JPanel
     *
     * @param panelName the string corresponding to the Panel.
     *
     */
    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }



}
