package Interface_and_Adapters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalyticsScreen extends JPanel implements ActionListener {
    /* Displays analytics information to the user.
     */
    public AnalyticsScreen(){
        JLabel title = new JLabel("These are the analytics");
        this.add(title);

    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
