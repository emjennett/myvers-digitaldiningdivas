package Interface_and_Adapters.start_up_screens;

import APP_Business_Rules.login_user.*;
import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.AccountUserFile;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SignUpScreenOwner extends JPanel {
        JPanel mainPanel;

        JTextField username = new JTextField(15);
        JPasswordField password = new JPasswordField(15);
        JPasswordField retypePassword = new JPasswordField(15);
        JButton cancel;

        CreateUserController controller;
        public SignUpScreenOwner(CreateUserController controller, JPanel mainPanel) {

            this.controller = controller;
            this.mainPanel = mainPanel;

            this.add(Box.createVerticalGlue());
            JLabel title = new JLabel("Sign-Up");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
            LabelHelper usernameBox = new LabelHelper(new JLabel("Select Username"), username);
            LabelHelper passwordBox = new LabelHelper(new JLabel("Choose Password"), password);
            LabelHelper enterPasswordAgainBox = new LabelHelper(new JLabel("Confirm Password"), retypePassword);

            JPanel buttons = new JPanel();
            buttons.add(createCreateButton());
            buttons.add(createCancelButton());

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.add(title);
            this.add(usernameBox);
            this.add(passwordBox);
            this.add(enterPasswordAgainBox);
            this.add(buttons);
            this.add(Box.createVerticalGlue());


        }

        private JButton createCreateButton() {
            cancel = new JButton("Create Account");
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        controller.create(username.getText(), String.valueOf(password.getPassword()),
                                String.valueOf(retypePassword.getPassword()), "owner");
                        JOptionPane.showMessageDialog(SignUpScreenOwner.this,
                                "You have successfully created your account " + username.getText() + "!");
                        LoginUserGateway user;
                        user = new UserFile("./users.csv");
                        AccountUserGateway account;
                        account = new AccountUserFile("./accounts.csv");
                        LoginUserPresenter presenter = new LoginUserResponse();
                        UserFactory userFactory = new AccountFactory();
                        LoginUserInputBoundary interactor = new LoginUserInteractor(
                                user, account, userFactory, presenter);
                        LoginUserController controller = new LoginUserController(interactor);
                        Main main = new Main();
                        mainPanel.add(new LoginScreen(controller, mainPanel), "THIRD");
                        main.switchPanel(mainPanel, "THIRD");


                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(SignUpScreenOwner.this, ex.getMessage());
                    }


                }

            });
            return cancel;

        }
        private JButton createCancelButton() {
            cancel = new JButton("Cancel");
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main main = new Main();
                    main.switchPanel(mainPanel, "FIRST");

                }

            });
            return cancel;

        }
    }



