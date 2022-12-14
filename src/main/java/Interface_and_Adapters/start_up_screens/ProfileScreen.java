package Interface_and_Adapters.start_up_screens;


import APP_Business_Rules.LoadAccountInfo.PullAccountInfoController;
import APP_Business_Rules.LoadAccountInfo.UserAccountInfoFile;
import APP_Business_Rules.LoadAccountInfo.UserAccountInfoModel;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.Main;
import Interface_and_Adapters.TabPanel;
import Interface_and_Adapters.WelcomeScreen;
import Interface_and_Adapters.restaurant_screens.RestaurantController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProfileScreen extends JPanel  {

    JButton btn;

    JButton backbtn;

    JLabel label;

    JPanel firstpanel = new JPanel();


    JPanel cont = new JPanel();

    CardLayout layout = new CardLayout();

    JPanel mainscreen;
    JTextField resName = new JTextField(15);
    JTextField resCat = new JTextField(15);
    JTextField location = new JTextField(15);
    JTextField stars = new JTextField(5);

    RestaurantController resController;
    LoginUserResponseModel account;

    public ProfileScreen(LoginUserResponseModel account, JPanel mainscreen, RestaurantController resController){

        this.resController = resController;
        this.account = account;
        this.mainscreen = mainscreen;
        PullAccountInfoController controller = new PullAccountInfoController(account.getUsername());
        String bio = controller.GetBio();
        String user = account.getUsername();


        btn = new JButton("ChangeBio");

        backbtn = new JButton("Log Out");

        label = new JLabel("Profile");

        label.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel message = new JLabel("Please log out to view new Bio");


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            //opens restaurant window with jbuttons from "home" screen
            {
                ChangeBio newscreen = new ChangeBio(account, cont, mainscreen);
                cont.add(newscreen, "C1");
                switchPanel(cont, "C1");


            }
        });

        backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            //opens restaurant window with jbuttons from "home" screen
            {
                Main main = new Main();
                main.switchPanel(mainscreen, "FIRST");

            }
        });
        JPanel resPanel = new JPanel();
        resPanel.setLayout(new BoxLayout(resPanel, BoxLayout.Y_AXIS));
        resPanel.add(Box.createVerticalGlue());
        if(account.getType().equals("owner")) {

            JLabel createResTitle = new JLabel("Create new Restaurant");
            createResTitle.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
            LabelHelper resTitleBox = new LabelHelper(new JLabel("Input Restaurant Name"), resName);
            LabelHelper resCatBox = new LabelHelper(new JLabel("Input Restaurant Category"), resCat);
            LabelHelper resLocationBox = new LabelHelper(new JLabel("Input Restaurant Location"), location);
            LabelHelper resStarBox = new LabelHelper(new JLabel("Input Michelin Stars"), stars);

            resPanel.add(createResTitle);

            resPanel.add(resTitleBox);
            resPanel.add(resCatBox);
            resPanel.add(resLocationBox);
            resPanel.add(resStarBox);
            resPanel.add(createResButton());


        }
        resPanel.add(Box.createVerticalGlue());

        DefaultListModel<String> mylist = new DefaultListModel<>();
        mylist.addElement("Username: " + user);
        mylist.addElement("Bio:" + bio);


        JList<String> list = new JList<>(mylist);
        list.setFont(new Font("Arial", Font.BOLD,20));
        list.setSize(100, 500);


        firstpanel.setLayout(new BoxLayout(firstpanel, BoxLayout.Y_AXIS));
        firstpanel.setSize(800, 600);
        firstpanel.add(label);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        backbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        list.setAlignmentX(Component.CENTER_ALIGNMENT);
        message.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstpanel.add(Box.createRigidArea(new Dimension(0,13)));
        firstpanel.add(Box.createVerticalGlue());
        firstpanel.add(label);
        firstpanel.add(Box.createRigidArea(new Dimension(0,13)));
        firstpanel.add(message);
        firstpanel.add(Box.createRigidArea(new Dimension(0,13)));
        firstpanel.add(list);
        firstpanel.add(Box.createRigidArea(new Dimension(0,30)));
        firstpanel.add(btn);
        firstpanel.add(Box.createRigidArea(new Dimension(0,30)));
        firstpanel.add(backbtn);

        cont.setLayout(layout);


        cont.add(firstpanel, "1");
        this.add(cont);
        this.add(resPanel);


    }

    private JButton createResButton() {
        JButton newRes = new JButton("Create New Restaurant");
        newRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resController.create(resName.getText(), resCat.getText(), location.getText(), Integer.parseInt(stars.getText()));
                JOptionPane.showMessageDialog(ProfileScreen.this,
                        "Your restaurant " + resName.getText() + " has successfully been created!");
                Main main = new Main();
                try {
                    mainscreen.add(new TabPanel(mainscreen, account), "FOURTH");
                    main.switchPanel(mainscreen, "FOURTH");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        return newRes;

    }

    /**
     * switchPanel:
     * method that changes the current Jpanel
     *
     * @param container the current JPanel
     *
     * @param panelName the string corresponding to the Panel.
     *
     */
    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }



}
