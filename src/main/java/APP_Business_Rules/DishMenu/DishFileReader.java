package APP_Business_Rules.DishMenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DishFileReader implements DishDataAccess{
    /*
    Reads from Dishes.csv file and returns a formatted list to retrieve information
    effectively by outside classes.
     */
    String file;
    HashMap<String, List<List<String>>> dishes = new HashMap<String, List<List<String>>>();

    public DishFileReader(String file){
        this.file = file;
    }

    public HashMap<String, List<List<String>>> createList() {
        //returns dishes as a Hashmap of Restaurant strings to a list of values, values are lists of strings
        //corresponding to attributes of dishes

        String line = "";
        String splitBy = ",";
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine(); // skip header
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] dish = line.split(splitBy);
                String key = dish[0];

                if (!dishes.containsKey(key)){
                    List<List<String>> values = new ArrayList<>();
                    dishes.put(key, values);
                }
                List<String> listPiece = new ArrayList<>(dish.length);
                for(int i = 1; i < dish.length; i++)
                {
                    listPiece.add(dish[i]);
                }
                dishes.get(key).add(listPiece);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishes;
    }
    @Override
    public List<List<String>> getDish(String resName){
        DishFileReader fileReader = new DishFileReader(file);
        HashMap<String, List<List<String>>> allDishes = fileReader.createList();
        return allDishes.get(resName);
    }

    @Override
    public boolean dishExistsByName(String identifier){
        return dishes.equals(identifier);
    }

}