package Interface_and_Adapters;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantScreen extends JPanel implements ActionListener {
    /* Displays Restaurant information to the user.
     */
    public RestaurantScreen(){
        JLabel title = new JLabel("This is a Restaurant");
        this.add(title);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
