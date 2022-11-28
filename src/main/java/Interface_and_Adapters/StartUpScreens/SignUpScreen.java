package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.create_user.CreateUserController;
import APP_Business_Rules.login_user.*;
import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.AccountUserFile;
import Frameworks_and_Drivers.UserFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUpScreen extends JPanel implements ActionListener {

    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JPasswordField retypePassword = new JPasswordField(15);

    CreateUserController controller;
    public SignUpScreen(CreateUserController controller){
        this.controller = controller;

        JLabel title = new JLabel("Sign-Up");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelHelper usernameBox = new LabelHelper(new JLabel("Select Username"), username);
        LabelHelper passwordBox = new LabelHelper(new JLabel("Choose Password"), password);
        LabelHelper enterPasswordAgainBox = new LabelHelper(new JLabel("Confirm Password"), retypePassword);
        JButton create = new JButton("Create Account");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(cancel);

        create.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernameBox);
        this.add(passwordBox);
        this.add(enterPasswordAgainBox);
        this.add(buttons);


        cancel.addActionListener(e -> {

            ((Window) getRootPane().getParent()).dispose();
            JFrame frame = new JFrame("Digital Dining Divas");
            frame.setSize(500, 180);
            frame.setResizable(false);
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.setResizable(false);
            StartUpScreen screen = new StartUpScreen();
            frame.add(screen);
            frame.setVisible(true);

        });
    }


    @Override
    public void actionPerformed(ActionEvent i) {

        try {
            controller.create(username.getText(), String.valueOf(password.getPassword()),
                    String.valueOf(retypePassword.getPassword()));
            JOptionPane.showMessageDialog(this,
                    "You have successfully created your account " + username.getText() + "!");
            ((Window) getRootPane().getParent()).dispose();
            JFrame frame = new JFrame("Digital Dining Divas");
            frame.setSize(500, 200);
            frame.setResizable(false);
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            LoginUserGateway user;
            user = new UserFile("./users.txt");
            AccountUserGateway account;
            account = new AccountUserFile("./accounts.txt");
            LoginUserPresenter presenter = new LoginUserResponse();
            UserFactory userFactory = new AccountFactory();
            LoginUserInputBoundary interactor = new LoginUserInteractor(
                    user, account, userFactory, presenter);
            LoginUserController controller = new LoginUserController(interactor);
            LoginScreen screen = new LoginScreen(controller);
            frame.add(screen);
            frame.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}

