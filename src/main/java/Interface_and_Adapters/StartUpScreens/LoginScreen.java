package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.login_user.LoginUserController;
import APP_Business_Rules.login_user.LoginUserResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginScreen extends JPanel implements ActionListener {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);

    LoginUserController controller;
    public LoginScreen(LoginUserController controller) {
        this.controller = controller;

        JLabel title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelHelper usernameBox = new LabelHelper(new JLabel("Username"), username);
        LabelHelper passwordBox = new LabelHelper(new JLabel("Password"), password);
        JButton login = new JButton("Login");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(login);
        buttons.add(cancel);

        login.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernameBox);
        this.add(passwordBox);
        this.add(buttons);

        cancel.addActionListener(e -> {

            ((Window) getRootPane().getParent()).dispose();
            JFrame frame = new JFrame("Digital Dining Divas");
            frame.setSize(500, 180);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            StartUpScreen screen = new StartUpScreen();
            frame.add(screen);
            frame.setVisible(true);

        });
    }

    @Override
    public void actionPerformed(ActionEvent i) {

        try {
            LoginUserResponseModel account = controller.login(
                    username.getText(), String.valueOf(password.getPassword()));
            ((Window) getRootPane().getParent()).dispose();
            JFrame frame = new JFrame("Digital Dining Divas");
            frame.setSize(500, 180);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            WelcomeScreen screen = new WelcomeScreen(account);
            frame.add(screen);
            frame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
