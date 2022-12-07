package Interface_and_Adapters.start_up_screens;
import APP_Business_Rules.login_user.*;
import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.AccountUserFile;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class StartUpScreen extends JPanel {
    private final JPanel mainPanel;
    private JButton createAccButton;

    private Image backgroundImage;
    private String fileName;
    private JButton createLoginButton;

    private JButton createOwnerButton;

    public StartUpScreen(JPanel mainPanel, String fileName) throws IOException{
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 200));
        this.fileName = fileName;
        backgroundImage = ImageIO.read(new File(fileName));
        Border greenline = BorderFactory.createLineBorder(new java.awt.Color(102, 166, 90), 5, true);
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new java.awt.Color(201, 250, 192));
        innerPanel.setPreferredSize(new Dimension(400, 200));

        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

        innerPanel.add(Box.createVerticalGlue());
        this.mainPanel = mainPanel;
        JLabel title = new JLabel();
        title.setText("Digital Dining Divas");
        title.setFont(new Font("Arial", Font.PLAIN, 30));

        JPanel buttons = new JPanel();
        buttons.setBackground(new java.awt.Color(201, 250, 192));
        buttons.add(createButton());
        buttons.add(createLoginButton());
        buttons.add(createOwnerButton());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        innerPanel.add(title);
        innerPanel.add(buttons);
        innerPanel.add(Box.createVerticalGlue());

        innerPanel.setBorder(greenline);

        this.add(innerPanel);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = Toolkit.getDefaultToolkit().getImage(fileName);
        int width = backgroundImage.getWidth(this);
        int height = backgroundImage.getHeight(this);
        int w = width/2+150;
        int h = height/2+150;

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, (int) w, (int) h, this);
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

    private JButton createOwnerButton() {
        createOwnerButton = new JButton("Sign Up as Owner");
        createOwnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.switchPanel(mainPanel, "FIFTH");

            }

        });
        return createOwnerButton;
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

