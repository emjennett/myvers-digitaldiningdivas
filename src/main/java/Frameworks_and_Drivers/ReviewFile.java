package Frameworks_and_Drivers;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewGateway;
import APP_Business_Rules.DisplayReviewsUseCase.LoadReviewsGateway;
import Entities.Review;
import Entities.ReviewableObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewFile implements CreateReviewGateway, LoadReviewsGateway {

    private final String txtFile = "./Reviews.csv";

    public ReviewFile() {


        if (txtFile.length() == 0){
            HashMap<ReviewableObject, List<Review>> reviews = new HashMap<ReviewableObject, List<Review>>();
            try{
                FileOutputStream file = new FileOutputStream(txtFile);
                ObjectOutputStream writer = new ObjectOutputStream(file);
                writer.writeObject(reviews);
                file.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void save(Object dishOrRestaurant, Review review) {

        DataAccessStorage dataGate = new DataAccessStorage();
        HashMap<Object, List<Review>> reviewData = (HashMap<Object, List<Review>>) dataGate.accessData(this.txtFile);

        if (reviewData.containsKey(dishOrRestaurant)){
            reviewData.get(dishOrRestaurant).add(0,review);
            dataGate.storeData(this.txtFile, reviewData);
        }
        else{
            List<Review> rList = new ArrayList<Review>();
            rList.add(review);
            reviewData.put(dishOrRestaurant, rList);
            dataGate.storeData(this.txtFile, reviewData);
        }

    }

    @Override
    public List<Review> retrieveReviews(Object dishOrRestaurant) {

        DataAccessStorage dataGate = new DataAccessStorage();
        HashMap<Object, List<Review>> reviewData = (HashMap<Object, List<Review>>) dataGate.accessData(this.txtFile);
        if (reviewData.containsKey(dishOrRestaurant)){
            List<Review> rList = reviewData.get(dishOrRestaurant);
            dataGate.storeData(this.txtFile, reviewData);
            return rList;
        }
        else{
            dataGate.storeData(this.txtFile, reviewData);
            return null;
        }
    }
}
