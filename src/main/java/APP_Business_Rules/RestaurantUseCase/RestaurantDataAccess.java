package APP_Business_Rules.RestaurantUseCase;

import java.util.List;
import java.util.Set;

public interface RestaurantDataAccess {
    boolean existsByName(String identifier);
    List<List<String>> getRes(String file);

}
