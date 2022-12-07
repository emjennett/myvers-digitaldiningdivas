package Interface_and_Adapters;


import APP_Business_Rules.create_user.*;

import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.start_up_screens.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main extends JFrame{

    public Main() {
        CreateUserGateway user;
        user = new UserFile("./users.csv");
        CreateUserPresenter presenter = new CreateUserResponse();
        UserFactory userFactory = new AccountFactory();
        CreateUserInputBoundary interactor = new CreateUserInteractor(
                user, userFactory, presenter);
        CreateUserController controller = new CreateUserController(interactor);
        //

        this.setTitle("Digital Dining Divas");
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());
        try {
            mainPanel.add(new StartUpScreen(mainPanel, "./bg.png"), "FIRST");
        } catch(IOException e) {
            System.out.println("Completed!");
        }

        mainPanel.add(new SignUpScreen(controller, mainPanel), "SECOND");
        mainPanel.add(new SignUpScreenOwner(controller, mainPanel), "FIFTH");
        this.setContentPane(mainPanel);

    }

    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}
