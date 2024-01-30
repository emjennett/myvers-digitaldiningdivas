package APP_Business_Rules.RestaurantUseCase;

import APP_Business_Rules.login_user.LoginUserGatewayModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RestaurantDataAccess {
    /*
    Passes Restaurant information from the file reader to the Restaurant interactor and screens
     */
    RestaurantGatewayModel save(RestaurantGatewayModel model);

    Map<String, RestaurantGatewayModel> getAllRes();
}
