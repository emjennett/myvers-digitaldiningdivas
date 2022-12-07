package Interface_and_Adapters.start_up_screens;

import APP_Business_Rules.LoadAccountInfo.ChangeBioController;
import APP_Business_Rules.LoadAccountInfo.PullAccountInfoController;
import APP_Business_Rules.LoadAccountInfo.UserAccountInfoFile;
import APP_Business_Rules.LoadAccountInfo.UserAccountInfoModel;
import APP_Business_Rules.login_user.LoginUserResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBio extends JPanel {


    JTextField biotextfield = new JTextField(15);


    public ChangeBio(LoginUserResponseModel account, JPanel panel, JPanel main){
        JLabel title = new JLabel("New Bio");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelHelper usernameBox = new LabelHelper(new JLabel("Select new Bio"), biotextfield);
        JButton button = new JButton("Enter");
        JPanel secondPanel = new JPanel();

        JButton backbutton = new JButton("Back");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            //opens restaurant window with jbuttons from "home" screen
            {
                String newbio = biotextfield.getText();
//                UserAccountInfoFile file = new UserAccountInfoFile("./AccountInfo.csv");
//                UserAccountInfoModel model = file.load(account.getUsername());
//                file.change(model.getUser(), newbio);
                ChangeBioController controller = new ChangeBioController(account.getUsername(), newbio);
                controller.UpdateBio();
                ProfileScreen profile = new ProfileScreen(account, main);
                profile.switchPanel(panel, "1");

            }
        });

        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            //opens restaurant window with jbuttons from "home" screen
            {
                ProfileScreen profile = new ProfileScreen(account, main);
                profile.switchPanel(panel, "1");

            }
        });
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
        secondPanel.add(title);
        secondPanel.add(usernameBox);
        secondPanel.add(button);
        secondPanel.add(backbutton);
        this.add(secondPanel);



    }










}
