package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.login_user.LoginUserController;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginScreen extends JPanel {
    private final JPanel mainPanel;
    private JButton cancel;
    private JButton login;
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);

    LoginUserController controller;

    public LoginScreen(LoginUserController controller, JPanel mainPanel) {
        this.controller = controller;
        this.mainPanel = mainPanel;

        JLabel title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelHelper usernameBox = new LabelHelper(new JLabel("Username"), username);
        LabelHelper passwordBox = new LabelHelper(new JLabel("Password"), password);

        JPanel buttons = new JPanel();
        buttons.add(createLoginButton());
        buttons.add(createCancelButton());


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernameBox);
        this.add(passwordBox);
        this.add(buttons);
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

    private JButton createLoginButton() {
        login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoginUserResponseModel account = controller.login(
                            username.getText(), String.valueOf(password.getPassword()));
                    Main main = new Main();
                    main.switchPanel(mainPanel, "FOURTH");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(LoginScreen.this, ex.getMessage());
                }
            }

        });
        return login;

    }
}

