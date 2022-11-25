package APP_Business_Rules.RestaurantUseCase;

import Entities.AccountOwner;
import Entities.Restaurant;
import Frameworks_and_Drivers.DataAccessStorage;

public class RestaurantFactory {
    /* Creates and stores Restaurant upon request from Account Owner
     */
    public Restaurant create(String resName, String resCategory){
        return new Restaurant(resName, resCategory);
    }

}
