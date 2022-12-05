package Interface_and_Adapters.StartUpScreens;


import APP_Business_Rules.LoadAccountInfo.UserAccountInfoFile;
import APP_Business_Rules.LoadAccountInfo.UserAccountInfoModel;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.RestaurantPopUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileScreen extends JPanel  {

    JButton btn;

    JList<String> list;

    JLabel label;


    public ProfileScreen(LoginUserResponseModel account){
        this.setSize(800, 600);
        JPanel firstpanel  = new JPanel();

        UserAccountInfoFile test = new UserAccountInfoFile("./AccountInfo.csv");

        if (!test.findAccountUser(account.getUsername())){
            test.save(new UserAccountInfoModel(account.getUsername()));
        }

        UserAccountInfoModel model = test.load(account.getUsername());
        String bio = model.getBio();

        String user = account.getUsername();


        btn = new JButton("ChangeBio");

        label = new JLabel("Profile");

        label.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel message = new JLabel("please log out to view new Bio");


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            //opens restaurant window with jbuttons from "home" screen
            {
                JPanel newscreen = new ChangeBio(account, firstpanel);
                firstpanel.add(newscreen);
//                switchPanel(firstpanel, "Card 1");
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
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
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


        this.add(firstpanel);



    }
    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String msg = "";
//
//        if (list.getSelectedIndex() != 1){
//            msg = "you selected :" + list.getSelectedValue();
//            label.setText(msg);
//        }
//    }
}
