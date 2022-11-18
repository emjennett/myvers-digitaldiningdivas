package APP_Business_Rules;

import Entities.*;

import java.util.HashMap;

public interface DataAccessStorageInterface {
    // Interface for retrieving and saving data to and from a database.
    Object accessData(String fileName);
    void storeData(String fileName, Object inputData);

}
