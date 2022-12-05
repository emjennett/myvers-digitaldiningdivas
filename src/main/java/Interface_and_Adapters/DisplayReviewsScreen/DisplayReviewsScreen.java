package Interface_and_Adapters.DisplayReviewsScreen;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewRequestModel;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewResponseModel;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewController;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsResponseModel;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewInputBoundary;
import Entities.Review;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewScreen;
import Interface_and_Adapters.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DisplayReviewsScreen {
    private DisplayReviewsController controller;
    private Object reviewed;
    private List<Review> reviews;
    private JList<String> listOfReviews;
    private JTextArea reviewText;
    private JLabel dateCreated;
    private JLabel objectReviewd;
    private JLabel reviewRating;
    private JLabel authorName;
    private JButton thumbsUP;
    private JLabel dateCreatedLabel;
    private JButton cancelButton;
    private JButton newReviewButton;

    public DisplayReviewsScreen(DisplayReviewsController controller, Object reviewed){

        this.controller = controller;

        this.reviewed = reviewed;

        DisplayReviewsResponseModel lst = this.controller.create(this.reviewed);

        this.reviews = lst.getReviews();

        DefaultListModel<String> model = new DefaultListModel<>();

        this.listOfReviews = new JList<>(model);

        for (int i = 0; i < this.reviews.size(); i++){

            model.addElement((this.reviews.get(i).getAuthor() + ", " + this.reviews.get(i).getRatingString()));

        }

        listOfReviews.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()){
                    JList source = (JList)e.getSource();
                    Integer selected = source.getSelectedIndex();
                    reviewText.setText(reviews.get(selected).getReview());
                    dateCreated.setText(reviews.get(selected).getCreatedOn());
                    objectReviewd.setText(reviews.get(selected).getReviewed().getName());
                    reviewRating.setText(reviews.get(selected).getRatingString());
                    authorName.setText(reviews.get(selected).getAuthor());
                }

            }
        });
        thumbsUP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        newReviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateReviewController controller1 = new CreateReviewController()
                new CreateReviewScreen();

            }
        });
    }
}
