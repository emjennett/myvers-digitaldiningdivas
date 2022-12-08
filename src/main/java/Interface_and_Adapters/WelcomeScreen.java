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
        this.setLayout(new BorderLayout());
        this.add(Box.createVerticalGlue());


        JLabel title = new JLabel();
        title.setText("Welcome " + account.getType() + " " + account.getUsername()  + "!");
        title.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(title, BorderLayout.PAGE_START);

        if(account.getType().equals("owner")) {
            JPanel resPanel = new JPanel();
            resPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            GridBagConstraints d = new GridBagConstraints();
            GridBagConstraints e = new GridBagConstraints();
            GridBagConstraints f = new GridBagConstraints();
            GridBagConstraints g = new GridBagConstraints();
            GridBagConstraints h = new GridBagConstraints();

            resPanel.setPreferredSize(new Dimension(500, 500));
            JLabel createResTitle = new JLabel("<html>To add your restaurant to Digital Dining Divas,<br/> please fill in the" +
                    "text fields below and press the Create New Restaurant button<html>");
            c.gridx = 3;
            c.gridy = 0;
            LabelHelper resTitleBox = new LabelHelper(new JLabel("Input Restaurant Name"), resName);
            d.gridx = 3;
            d.gridy = 1;
            LabelHelper resCatBox = new LabelHelper(new JLabel("Input Restaurant Category"), resCat);
            e.gridx = 3;
            e.gridy = 2;
            LabelHelper resLocationBox = new LabelHelper(new JLabel("Input Restaurant Location"), location);
            f.gridx = 3;
            f.gridy = 3;
            LabelHelper resStarBox = new LabelHelper(new JLabel("Input Michelin Stars"), stars);
            g.gridx = 3;
            g.gridy = 4;

            h.gridx = 3;
            h.gridy = 5;

            resPanel.add(createResTitle, c);

            resPanel.add(resTitleBox, d);
            resPanel.add(resCatBox, e);
            resPanel.add(resLocationBox, f);
            resPanel.add(resStarBox, g);
            resPanel.add(createResButton(), h);
            this.add(resPanel, BorderLayout.LINE_END);

        }
        this.add(createLogoutButton(), BorderLayout.PAGE_END);
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
