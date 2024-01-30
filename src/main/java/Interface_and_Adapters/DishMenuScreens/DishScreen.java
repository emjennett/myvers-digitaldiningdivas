package Interface_and_Adapters.DishMenuScreens;

import APP_Business_Rules.DishMenu.DishDataAccess;
import APP_Business_Rules.DishMenu.DishFileReader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class DishScreen extends JPanel {

    DishController dishController;
    String resName;
    //creates a screen that lists oll dishes for "resName". TO be displayed on the restaurant screen
    // of resName.
    public DishScreen(DishController dishController, String resName) {
        this.resName = resName;
        this.dishController = dishController;

        CardLayout cards = new CardLayout();
        this.setLayout(cards);

        JPanel subPanel = new JPanel(); //panel for button grid
        subPanel.setSize(new Dimension(200, 400));
        JScrollPane scroller = new JScrollPane(subPanel);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension( 150,300));

        subPanel.setLayout(new GridLayout(0, 1, 10, 10));
        subPanel.setBorder(new EmptyBorder(20, 50, 40, 50));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        DishDataAccess dishes;
        dishes = new DishFileReader("./Dishes.csv");
        //if no dishes have been uploaded, say so!

        if(dishes.getDish(resName)==null){
            JLabel noDishes= new JLabel();
            noDishes.setText("Stay tuned for dishes!");
            subPanel.add(noDishes, c);
        }
        //here, there are dishes for this restaurant
        else{
            for (List<String> element : dishes.getDish(resName)) {
                JButton button = new JButton(element.get(0) );
                button.setSize(new Dimension(40, 40));
                button.setBorderPainted(false);
                subPanel.add(button, c);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    //opens dish popup that contains dish information based on which dish was clicked on
                    {
                        DishPopUp popUp = new DishPopUp(resName, element.get(0), element.get(1), element.get(2),
                                element.get(3), element.get(4));
                        DishScreen.this.add(popUp, "card1");
                        CardLayout cl = (CardLayout)(DishScreen.this.getLayout());
                        cl.show(DishScreen.this, "card1");
                        GridBagConstraints c = new GridBagConstraints();
                        JButton backButton = new JButton("Back");
                        popUp.add(backButton);
                        backButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CardLayout cardLayout = (CardLayout) DishScreen.this.getLayout();
                                cardLayout.first(DishScreen.this); //returns to first screen by button click
                            }

                        });
                    }
                });

                c.gridy += 1;

            }
        }



        this.add(subPanel);
        this.setPreferredSize(new Dimension(500, 200));
        this.setVisible(true);

    }
}