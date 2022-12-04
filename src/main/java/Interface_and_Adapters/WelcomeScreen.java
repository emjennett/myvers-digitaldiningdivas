package Interface_and_Adapters;

import APP_Business_Rules.login_user.LoginUserResponseModel;

import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JPanel {

    LoginUserResponseModel account;

    public WelcomeScreen(LoginUserResponseModel account){
        this.account = account;

        JLabel title = new JLabel();
        title.setText("Welcome " + account.getUsername() + "!");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(title);

    }
}
