package Interface_and_Adapters.start_up_screens;

import javax.swing.*;
import java.awt.*;

public class ButtonHelper {
    ButtonHelper(){
    }
    public JButton formatButton(JButton jButton){
        jButton.setBackground(Color.WHITE);
        jButton.setOpaque(true);
        jButton.setFont(new Font("Roboto", Font.BOLD, 12));
        return jButton;
    }
}
