package Interface_and_Adapters.CreateReviewScreen;

import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsResponseModel;
import Entities.AccountUser;
import Entities.ReviewableObject;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import APP_Business_Rules.CreateReviewUseCase.*;

public class CreateReviewScreen {
    private JButton confirm;
    private JButton cancelButton;
    private JComboBox comboBoxRating;
    private JTextArea writeReview;
    private JPanel reviewedObjectTitle;
    private JLabel reviewedObject;
    private CreateReviewController controller;
    
    private ReviewableObject reviewed;

    private AccountUser author;

    public CreateReviewScreen(CreateReviewController controller, AccountUser author, ReviewableObject reviewed) {

        this.controller = controller;

        this.author = author;
        
        this.reviewed = reviewed;
        
        this.reviewedObject.setText(this.reviewed.getName());

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CreateReviewResponseModel newReview = controller.create(author, reviewed,
                        writeReview.getText(), comboBoxRating.getSelectedIndex());
            }
        });
        comboBoxRating.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    comboBoxRating.setVisible(true);
                    comboBoxRating.revalidate();
                    comboBoxRating.repaint();
                } else {
                    comboBoxRating.setVisible(false);
                }

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
