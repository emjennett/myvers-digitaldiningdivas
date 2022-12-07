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


public class StartUpScreen extends JPanel {
    private final JPanel mainPanel;
    private JButton createAccButton;
    private JButton createLoginButton;

    public StartUpScreen(JPanel mainPanel) {
        this.add(Box.createVerticalGlue());
        this.mainPanel = mainPanel;
        JLabel title = new JLabel();
        title.setText("Digital Dining Divas");
        title.setFont(new Font("Arial", Font.PLAIN, 30));

        JPanel buttons = new JPanel();
        buttons.add(createButton());
        buttons.add(createLoginButton());

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);
        this.add(buttons);
        this.add(Box.createVerticalGlue());
    }

    private JButton createButton() {
        createAccButton = new JButton("Sign Up");
        createAccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.switchPanel(mainPanel, "SECOND");

            }

        });
        return createAccButton;
    }

    private JButton createLoginButton() {
        createLoginButton = new JButton("Log In");
        createLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

            }

        });
        return createLoginButton;


    }
}

