package Interface_and_Adapters.start_up_screens;


import APP_Business_Rules.LoadAccountInfo.PullAccountInfoController;
import APP_Business_Rules.LoadAccountInfo.UserAccountInfoFile;
import APP_Business_Rules.LoadAccountInfo.UserAccountInfoModel;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.Main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileScreen extends JPanel  {

    JButton btn;

    JButton backbtn;

    JLabel label;

    JPanel firstpanel = new JPanel();


    JPanel cont = new JPanel();

    CardLayout layout = new CardLayout();






    public ProfileScreen(LoginUserResponseModel account, JPanel mainscreen){


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
