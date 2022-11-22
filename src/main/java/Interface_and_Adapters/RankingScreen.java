package Interface_and_Adapters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankingScreen extends JPanel implements ActionListener {
    /* Displays Information for Rankings to the user.
     */
    public RankingScreen(){
        JLabel title = new JLabel("These are the Rankings");
        this.add(title);

    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}