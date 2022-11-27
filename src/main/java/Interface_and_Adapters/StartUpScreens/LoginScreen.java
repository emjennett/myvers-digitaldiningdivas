package Interface_and_Adapters.StartUpScreens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginScreen extends JPanel implements ActionListener {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);


    public LoginScreen() {

        JLabel title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelHelper usernameBox = new LabelHelper(new JLabel("Username"), username);
        LabelHelper passwordBox = new LabelHelper(new JLabel("Password"), password);
        JButton login = new JButton("Login");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(login);
        buttons.add(cancel);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernameBox);
        this.add(passwordBox);
        this.add(buttons);

        login.addActionListener(e -> {

        });
        cancel.addActionListener(e -> {

            ((Window) getRootPane().getParent()).dispose();
            JFrame frame = new JFrame("Digital Dining Divas");
            frame.setSize(500, 180);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            StartUpScreen screen = new StartUpScreen();
            frame.add(screen);
            frame.setVisible(true);

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
