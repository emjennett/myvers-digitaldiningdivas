package APP_Business_Rules.RestaurantUseCase;

import APP_Business_Rules.login_user.LoginUserGatewayModel;

import java.util.List;
import java.util.Set;

public interface RestaurantDataAccess {
    /*
    Passes Restaurant information from the file reader to the Restaurant interactor and screens
     */
    boolean existsByName(String identifier);
    RestaurantGatewayModel save(RestaurantGatewayModel model);
    List<List<String>> getRes();

}
