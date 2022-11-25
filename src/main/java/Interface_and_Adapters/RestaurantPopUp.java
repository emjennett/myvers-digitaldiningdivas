package Interface_and_Adapters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantPopUp extends JPanel implements ActionListener {
    RestaurantPopUp(String resName, String resCategory, String address, String starRating){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel name = new JLabel(resName);
        int starCount = Integer.parseInt(starRating);
        System.out.println(starCount);
        for (int i = 0; i < starCount; i++) {
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.weighty = 1.0;
            c.gridx = 3;
            c.gridy = 1;
            JLabel imageLabel = new JLabel();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\Emily\\IdeaProjects\\course-project-digitaldiningdivas\\src\\main\\java\\Frameworks_and_Drivers\\19-star-png-image.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            imageLabel.setIcon(imageIcon);
            this.add(imageLabel, c);
        }

        name.setFont(new Font("Sans Serif", Font.BOLD, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 2;
        c.gridy = 0;
        this.add(name, c);
        c = new GridBagConstraints();
        JLabel category = new JLabel(resCategory);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 2;
        c.gridy = 1;
        this.add(category, c);
        c = new GridBagConstraints();
        JLabel addressLabel = new JLabel(address);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 1;
        c.gridy = 1;
        this.add(addressLabel, c);

        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


}
