package Interface_and_Adapters;

import APP_Business_Rules.RestaurantUseCase.*;
import APP_Business_Rules.login_user.LoginUserResponseModel;

import Interface_and_Adapters.restaurant_screens.RestaurantController;
import Interface_and_Adapters.restaurant_screens.RestaurantFormatted;
import Interface_and_Adapters.restaurant_screens.RestaurantPresenter;

import Interface_and_Adapters.start_up_screens.LabelHelper;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class WelcomeScreen extends JPanel {

    LoginUserResponseModel account;
    JPanel mainPanel;
    JTextField resName = new JTextField(15);
    JTextField resCat = new JTextField(15);
    JTextField location = new JTextField(15);
    JTextField stars = new JTextField(5);


    RestaurantController resController;

    public WelcomeScreen(LoginUserResponseModel account, JPanel mainPanel, RestaurantController resController){
        this.account = account;
        this.mainPanel = mainPanel;
        this.resController = resController;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());


        JLabel title = new JLabel();
        title.setText("Welcome " + account.getType() + " " + account.getUsername()  + "!");
        title.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(title);

        if(account.getType().equals("owner")) {

            JLabel createResTitle = new JLabel("Create new Restaurant");
            createResTitle.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
            LabelHelper resTitleBox = new LabelHelper(new JLabel("Input Restaurant Name"), resName);
            LabelHelper resCatBox = new LabelHelper(new JLabel("Input Restaurant Category"), resCat);
            LabelHelper resLocationBox = new LabelHelper(new JLabel("Input Restaurant Location"), location);
            LabelHelper resStarBox = new LabelHelper(new JLabel("Input Michelin Stars"), stars);

            this.add(createResTitle);

            this.add(resTitleBox);
            this.add(resCatBox);
            this.add(resLocationBox);
            this.add(resStarBox);
            this.add(createResButton());


        }
        this.add(Box.createVerticalGlue());
        this.add(createLogoutButton());
    }
    private JButton createResButton() {
        JButton newRes = new JButton("Create New Restaurant");
        newRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resController.create(resName.getText(), resCat.getText(), location.getText(), Integer.parseInt(stars.getText()));
                JOptionPane.showMessageDialog(WelcomeScreen.this,
                        "Your restaurant " + resName.getText() + " has successfully been created!");
                Main main = new Main();
                try {
                    mainPanel.add(new TabPanel(mainPanel, account), "FOURTH");
                    main.switchPanel(mainPanel, "FOURTH");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        return newRes;

    }

    private JButton createLogoutButton() {
        JButton logOut = new JButton("Log Out");
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.switchPanel(mainPanel, "FIRST");

            }

        });
        return logOut;

    }
}
