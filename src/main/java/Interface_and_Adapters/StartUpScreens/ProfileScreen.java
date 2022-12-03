package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.login_user.LoginUserResponseModel;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileScreen extends JPanel implements ActionListener {

    JButton btn;

    JList<String> list;

    JLabel label;

    public ProfileScreen(LoginUserResponseModel account){
//        this.setTitle("Profile");
        this.setSize(800, 600);
//        this.setLocationRelativeTo(null);
//        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String user = account.getUsername();
        this.setLayout(null);
        btn = new JButton("ChangeBio");
        btn.setBounds(50, 130, 100, 50);
        label = new JLabel("Profile");
        label.setBounds(75, 1, 50, 30);




        DefaultListModel<String> mylist = new DefaultListModel<>();
        mylist.addElement("Username: " + user);
        mylist.addElement("Bio:");
        mylist.addElement("Recent Restaurants: ");
        mylist.addElement("Recent Dishes: ");

        JList<String> list = new JList<>(mylist);
        list.setBounds(0, 25, 200, 100);

        this.add(list);
        this.add(btn);
        this.add(label);
        this.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = "";

        if (list.getSelectedIndex() != 1){
            msg = "you selected :" + list.getSelectedValue();
            label.setText(msg);
        }
    }
}
