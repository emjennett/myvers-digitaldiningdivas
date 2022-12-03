package APP_Business_Rules.RestaurantUseCase;

import APP_Business_Rules.login_user.LoginUserGatewayModel;

import java.util.List;
import java.util.Set;

public interface RestaurantDataAccess {
    boolean existsByName(String identifier);
    RestaurantGatewayModel loadRestaurant(RestaurantGatewayModel model);
    List<List<String>> getRes();

}
