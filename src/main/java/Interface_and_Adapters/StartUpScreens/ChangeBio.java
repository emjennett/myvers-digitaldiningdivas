package Interface_and_Adapters.StartUpScreens;

import APP_Business_Rules.LoadAccountInfo.UserAccountInfoFile;
import APP_Business_Rules.LoadAccountInfo.UserAccountInfoModel;
import APP_Business_Rules.login_user.LoginUserResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBio extends JPanel {

    JButton btn;

    JList<String> list;

    JLabel label;

    JTextField biotextfield = new JTextField(15);


    public ChangeBio(LoginUserResponseModel account, JPanel panel){
        JLabel title = new JLabel("New Bio");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelHelper usernameBox = new LabelHelper(new JLabel("Select new Bio"), biotextfield);
        JButton button = new JButton("Enter");
        JPanel secondPanel = new JPanel();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            //opens restaurant window with jbuttons from "home" screen
            {
                String newbio = biotextfield.getText();
                UserAccountInfoFile file = new UserAccountInfoFile("./AccountInfo.csv");
                UserAccountInfoModel model = file.load(account.getUsername());
                file.change(model.getUser(), newbio);
//                ProfileScreen newscreen = new ProfileScreen(account);
//                secondPanel.add(newscreen);

            }
        });
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
        secondPanel.add(title);
        secondPanel.add(usernameBox);
        secondPanel.add(button);
        this.add(secondPanel);
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(title);
//        this.add(usernameBox);
//        this.add(button);


    }










}
