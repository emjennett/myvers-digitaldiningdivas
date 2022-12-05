package Interface_and_Adapters.StartUpScreens;
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
        this.mainPanel = mainPanel;
        JLabel title = new JLabel();
        title.setText("Digital Dining Divas");
        title.setFont(new Font("Arial", Font.PLAIN, 30));

        JPanel buttons = new JPanel();
        buttons.add(createButton());
        buttons.add(createLoginButton());

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }

    private JButton createButton() {
        createAccButton = new JButton("Sign Up");
        createAccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                //main.switchPanel(mainPanel, "SECOND"); generates error

            }

        });
        return createAccButton;
    }

    private JButton createLoginButton() {
        createLoginButton = new JButton("Log In");
        createLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                //main.switchPanel(mainPanel, "THIRD"); generates error

            }

        });
        return createLoginButton;


    }
}

