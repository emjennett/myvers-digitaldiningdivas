package Interface_and_Adapters;

import APP_Business_Rules.login_user.LoginUserResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JPanel {

    LoginUserResponseModel account;
    JPanel mainPanel;

    public WelcomeScreen(LoginUserResponseModel account, JPanel mainPanel){
        this.account = account;
        this.mainPanel = mainPanel;

        JLabel title = new JLabel();
        title.setText("Welcome " + account.getUsername() + "!");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(title);

    }
    private JButton createLogoutButton() {
        JButton logOut = new JButton("Cancel");
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
