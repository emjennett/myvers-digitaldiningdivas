package APP_Business_Rules.RestaurantUseCase;

import APP_Business_Rules.create_user.CreateUserGatewayModel;
import APP_Business_Rules.login_user.LoginUserGatewayModel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantFileReader implements RestaurantDataAccess {
    /*
    Reads from Restaurants.csv file and returns a formatted list to retrieve information
    effectively by outside classes.
     */
    private final File csvFile;

    public RestaurantFileReader(String csvpath) {

        this.csvFile = new File(csvpath);
        Map<String, LoginUserGatewayModel> accounts = new HashMap<>();

        if (csvFile.length() == 0) {

            try {
                FileOutputStream file = new FileOutputStream(csvpath);
                ObjectOutputStream writer = new ObjectOutputStream(file);
                writer.writeObject(accounts);
                file.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public Map<String, RestaurantGatewayModel> getAllRes() {

        Map<String, RestaurantGatewayModel> restaurants;

        try {
            FileInputStream file = new FileInputStream(this.csvFile);
            ObjectInputStream reader = new ObjectInputStream(file);
            restaurants = (Map) reader.readObject();
            reader.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);


        }
        return restaurants;
    }
    @Override
    public RestaurantGatewayModel save (RestaurantGatewayModel model){
        Map<String, RestaurantGatewayModel> accounts;

        try {
            FileInputStream file = new FileInputStream(this.csvFile);
            ObjectInputStream reader = new ObjectInputStream(file);
            accounts = (Map) reader.readObject();
            reader.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Update the existing model with the new bio
        accounts.remove(model.getResName());
        accounts.put(model.getResName(), model);

        try {
            FileOutputStream file = new FileOutputStream(csvFile);
            ObjectOutputStream writer = new ObjectOutputStream(file);
            writer.writeObject(accounts);
            file.close();

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Return the updated model
        return model;

    }


}