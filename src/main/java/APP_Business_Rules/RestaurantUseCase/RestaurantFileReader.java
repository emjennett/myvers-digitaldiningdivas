package APP_Business_Rules.RestaurantUseCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantFileReader implements RestaurantDataAccess{
    /*
    Reads from Restaurants.csv file and returns a formatted list to retrieve information
    effectively by outside classes.
     */

    List<List<String>> restaurants = new ArrayList<List<String>>();
    public RestaurantFileReader(){

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
                for(String element : restaurant)
                {
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
    public List<List<String>> getRes(String file){
        RestaurantFileReader fileReader = new RestaurantFileReader();
        return fileReader.createList(file);
    }


    @Override
    public boolean existsByName(String identifier){
        return restaurants.equals(identifier);
    }
}