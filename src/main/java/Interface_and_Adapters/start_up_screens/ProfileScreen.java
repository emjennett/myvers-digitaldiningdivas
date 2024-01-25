package Interface_and_Adapters.start_up_screens;


import APP_Business_Rules.LoadAccountInfo.*;
import APP_Business_Rules.RestaurantUseCase.RestaurantFactory;
import APP_Business_Rules.RestaurantUseCase.RestaurantInputBoundary;
import APP_Business_Rules.RestaurantUseCase.RestaurantInteractor;
import APP_Business_Rules.login_user.AccountUserGateway;
import APP_Business_Rules.login_user.LoginUserPresenter;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Entities.AccountOwner;
import Frameworks_and_Drivers.AccountUserFile;
import Interface_and_Adapters.Main;
import Interface_and_Adapters.TabPanel;
import Interface_and_Adapters.WelcomeScreen;
import Interface_and_Adapters.restaurant_screens.RestaurantController;
import Interface_and_Adapters.restaurant_screens.RestaurantFormatted;
import Interface_and_Adapters.restaurant_screens.RestaurantPresenter;


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
    JLabel imageLabel;

    JPanel firstpanel = new JPanel();


    JPanel cont = new JPanel();

    CardLayout layout = new CardLayout();

    JPanel mainscreen;
    JTextField resName = new JTextField(15);
    JTextField resCat = new JTextField(15);
    JTextField location = new JTextField(15);
    JTextField stars = new JTextField(5);
    JTextField newBio = new JTextField(15);
    JTextField newPic = new JTextField(15);
    JLabel userType = new JLabel();


    RestaurantController resController;
    LoginUserResponseModel account;

    public ProfileScreen(LoginUserResponseModel account, JPanel mainscreen, RestaurantController resController){

        this.resController = resController;
        this.account = account;
        this.mainscreen = mainscreen;

        String bio = account.getBio();
        String user = account.getUsername();


        btn = new JButton("ChangeBio");
        imageBtn = new JButton("Change profile picture");

        backbtn = new JButton("Log Out");

        label = new JLabel("Profile");

        label.setFont(new Font("Arial", Font.BOLD, 20));

        message = new JLabel(bio);
        LoginUserPresenter presenter = new LoginUserResponse();
        AccountUserGateway gateway = new AccountUserFile("./accounts.csv");
        PullAccountInputBoundary interactor = new PullAcountInteractor(account, presenter, gateway);
        PullAccountInfoController controller = new PullAccountInfoController(interactor);

        imageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUserResponseModel response = controller.updateBio(account.getUsername(), newBio.getText(), account.getDate(), newPic.getText());
                JOptionPane.showMessageDialog(ProfileScreen.this,
                        "Your bio has successfully been updated!");
                Main main = new Main();
                DisplayImage("./"+response.getPic());

                try {
                    mainscreen.add(new TabPanel(mainscreen, response), "FOURTH");
                    main.switchPanel(mainscreen, "FOURTH");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            //opens restaurant window with jbuttons from "home" screen
            {
                LoginUserResponseModel response = controller.updateBio(account.getUsername(), newBio.getText(), account.getDate(), newPic.getText());
                JOptionPane.showMessageDialog(ProfileScreen.this,
                        "Your bio has successfully been updated!");

                Main main = new Main();
                message = new JLabel(response.getBio());
                try {
                    mainscreen.add(new TabPanel(mainscreen, response), "FOURTH");
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

        resPanel.add(Box.createVerticalGlue());

        DefaultListModel<String> mylist = new DefaultListModel<>();
        mylist.addElement("Username: " + user);
        mylist.addElement("Bio:" + account.getBio());


        JList<String> list = new JList<>(mylist);
        list.setFont(new Font("Arial", Font.BOLD,20));
        list.setSize(100, 500);


        firstpanel.setLayout(new BoxLayout(firstpanel, BoxLayout.Y_AXIS));
        firstpanel.setSize(800, 600);
        firstpanel.add(label);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        backbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        list.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstpanel.add(Box.createRigidArea(new Dimension(0,13)));
        firstpanel.add(Box.createVerticalGlue());
        firstpanel.add(label);

        JLabel imagee = DisplayImage("./face.jpg");

        firstpanel.add(imagee);
        firstpanel.add(userType);
        firstpanel.add(message);
        firstpanel.add(Box.createRigidArea(new Dimension(0,13)));
        firstpanel.add(Box.createRigidArea(new Dimension(0,13)));
        firstpanel.add(list);
        firstpanel.add(newBio);
        firstpanel.add(Box.createRigidArea(new Dimension(0,30)));
        firstpanel.add(btn);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

        String formattedate = account.getDate().format(formatter);
        JLabel createdOn = new JLabel("account created on: " + formattedate);
        firstpanel.add(createdOn);

        firstpanel.add(Box.createRigidArea(new Dimension(0,30)));
        firstpanel.add(backbtn);

        cont.setLayout(layout);
        cont.add(firstpanel, "1");
        this.add(cont);
        this.add(resPanel);


    }

    private JLabel DisplayImage(String url) {
        JLabel imagee = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
        imagee.setIcon(imageIcon);
        return imagee;
    }

    private JButton createResButton() {
        JButton newRes = new JButton("Create New Restaurant");
        newRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resController.create(resName.getText(), resCat.getText(), location.getText(), Integer.parseInt(stars.getText()));
                JOptionPane.showMessageDialog(ProfileScreen.this,
                        "Your restaurant " + resName.getText() + " has successfully been created!");

                Main main = new Main();
                try {
                    mainscreen.add(new TabPanel(mainscreen, account), "FOURTH");
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
