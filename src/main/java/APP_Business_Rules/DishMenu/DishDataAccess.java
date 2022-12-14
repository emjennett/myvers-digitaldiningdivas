package APP_Business_Rules.DishMenu;

import java.util.HashMap;
import java.util.List;

public interface DishDataAccess {
    boolean dishExistsByName(String identifier);
    List<List<String>> getDish(String file);
}