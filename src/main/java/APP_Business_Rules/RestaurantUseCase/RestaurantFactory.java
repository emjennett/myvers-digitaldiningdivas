package APP_Business_Rules.RestaurantUseCase;

import Entities.AccountOwner;
import Entities.Restaurant;
import Frameworks_and_Drivers.DataAccessStorage;

import java.util.List;

public class RestaurantFactory {
    /* Creates and stores Restaurant upon request from Account Owner
     */
    Restaurant create(String resName, String resCategory, String location, int stars, List<String> likeList, String newLike){
        return new Restaurant(resName, resCategory, location, stars, likeList, newLike);
    }

}
