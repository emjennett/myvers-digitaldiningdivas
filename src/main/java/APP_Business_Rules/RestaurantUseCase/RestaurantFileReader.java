package APP_Business_Rules.RestaurantUseCase;

import APP_Business_Rules.create_user.CreateUserGatewayModel;
import APP_Business_Rules.login_user.LoginUserGatewayModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestaurantFileReader implements RestaurantDataAccess {
    /*
    Reads from Restaurants.csv file and returns a formatted list to retrieve information
    effectively by outside classes.
     */
    private String file;
    List<List<String>> restaurants = new ArrayList<List<String>>();

    public RestaurantFileReader(String file) {
        this.file = file;

    }

    public List<List<String>> createList(String file) {
        //returns restaurants as list of lists

        String line = "";
        String splitBy = ",";
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine(); // skip header
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] restaurant = line.split(splitBy);
                List<String> listPiece = new ArrayList<>(restaurant.length);
                for (String element : restaurant) {
                    listPiece.add(element);
                }
                restaurants.add(listPiece);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restaurants;
    }


    @Override
    public List<List<String>> getRes() {
        RestaurantFileReader fileReader = new RestaurantFileReader(file);
        return fileReader.createList(file);
    }


    @Override
    public boolean existsByName(String identifier) {
        return restaurants.equals(identifier);
    }
@Override
    public RestaurantGatewayModel save(RestaurantGatewayModel model) {
        List<String> restaurantInfo = new ArrayList<>();
        String resName = model.getResName();
        String resCategory = model.getResCategory();
        String resLocation = model.getResLocation();
        int stars = model.getStars();
        restaurantInfo.add(resName);
        restaurantInfo.add(resCategory);
        restaurantInfo.add(resLocation);
        restaurantInfo.add(Integer.toString(stars));

        try {
            String filename = file;
            BufferedWriter output = new BufferedWriter(new FileWriter(filename, true)); //the true will append the new data
            for (String x : restaurantInfo) {
                output.append(x);
                output.append(",");
            }
            output.newLine();
            output.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new RestaurantGatewayModel(resName, resCategory, resLocation, stars);
    }
}