package Frameworks_and_Drivers;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewGateway;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsGateway;
import Entities.Review;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewFile implements CreateReviewGateway, DisplayReviewsGateway {

    private final File csvFile = new File("./Reviews.csv");

    private final String filePath = "./Reviews.csv";

    public ReviewFile() {


        if (csvFile.length() == 0){
            HashMap<String, List<Review>> reviews = new HashMap<String, List<Review>>();
            try{
                FileOutputStream file = new FileOutputStream(csvFile);
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
    public void save(String dishOrRestaurant, Review review) {

        DataAccessStorage dataGate = new DataAccessStorage();
        HashMap<String, List<Review>> reviewData = (HashMap<String, List<Review>>) dataGate.accessData(this.filePath);

        if (reviewData.containsKey(dishOrRestaurant)){
            reviewData.get(dishOrRestaurant).add(0,review);
            dataGate.storeData(this.filePath, reviewData);
        }
        else{
            List<Review> rList = new ArrayList<Review>();
            rList.add(review);
            reviewData.put(dishOrRestaurant, rList);
            dataGate.storeData(this.filePath, reviewData);
        }

    }

    @Override
    public List<Review> retrieveReviews(String dishOrRestaurant) {

        DataAccessStorage dataGate = new DataAccessStorage();
        HashMap<String, List<Review>> reviewData = (HashMap<String, List<Review>>) dataGate.accessData(this.filePath);
        if (reviewData.containsKey(dishOrRestaurant)){
            List<Review> rList = reviewData.get(dishOrRestaurant);
            dataGate.storeData(this.filePath, reviewData);
            return rList;
        }
        else{
            dataGate.storeData(this.filePath, reviewData);
            return null;
        }
    }
}
