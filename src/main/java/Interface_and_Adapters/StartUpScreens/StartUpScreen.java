package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.create_user.*;
import APP_Business_Rules.login_user.*;
import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.AccountUserFile;
import Frameworks_and_Drivers.UserFile;

import javax.swing.*;
import java.awt.*;


public class StartUpScreen extends JPanel{

    public StartUpScreen(){
        JLabel title = new JLabel();
        title.setText("Digital Dining Divas");
        title.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton create = new JButton("Sign Up");
        JButton login = new JButton("Login");
        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(login);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);

        create.addActionListener(e -> {
            ((Window) getRootPane().getParent()).dispose();
            JFrame frame = new JFrame("Digital Dining Divas");
            frame.setSize(500, 200);
            frame.setResizable(false);
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            CreateUserGateway user;
            user = new UserFile("./users.txt");
            CreateUserPresenter presenter = new CreateUserResponse();
            UserFactory userFactory = new AccountFactory();
            CreateUserInputBoundary interactor = new CreateUserInteractor(
                    user, userFactory, presenter);
            CreateUserController controller = new CreateUserController(interactor);
            SignUpScreen screen = new SignUpScreen(controller);
            frame.add(screen);
            frame.setVisible(true);

        });

        login.addActionListener(e -> {
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
        });
    }
}
