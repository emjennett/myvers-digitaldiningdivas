package Interface_and_Adapters;

import APP_Business_Rules.RestaurantUseCase.RestaurantController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantPopUp extends JPanel{
    RestaurantController restaurantController;
    RestaurantPopUp(String resName, String resCategory, String address, String starRating,
                    RestaurantController restaurantController, JPanel mainPanel){
        this.restaurantController = restaurantController;

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel name = new JLabel(resName);
        int starCount = Integer.parseInt(starRating);
        System.out.println(starCount);
        for (int i = 0; i < starCount; i++) {
            c.fill = GridBagConstraints.CENTER;
            c.weightx = 0.5;
            c.weighty = 1.0;
            c.gridx = 3;
            c.gridy = 1;
            JLabel imageLabel = new JLabel();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("./19-star-png-image.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            imageLabel.setIcon(imageIcon);
            imageLabel.setHorizontalTextPosition(SwingConstants.LEFT);
            this.add(imageLabel, c);
            imageLabel.setText(imageLabel.getText()+ "Michelin Stars:");


        }
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurantScreen resScreen = new RestaurantScreen(restaurantController);
                resScreen.switchPanel(mainPanel, "one"); //returns to first screen by button click
            }

        });
        this.add(backButton);


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

        JButton reviewResButton = new JButton("Add Your Review");
        reviewResButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(reviewResButton);

        this.setPreferredSize(new Dimension(200, 300));
        this.setVisible(true);
    }




}
