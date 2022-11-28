package tutorial;

import Interface_and_Adapters.StartUpScreens.StartUpScreen;

import javax.swing.*;

public class HelloWorld {

    public static void main(String[] args) {

        StartUpScreen start = new StartUpScreen();

        JFrame frame = new JFrame("Digital Dining Divas");

        frame.setSize(500, 180);
        frame.setResizable(false);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        frame.add(start);
        frame.setVisible(true);



    }


}
