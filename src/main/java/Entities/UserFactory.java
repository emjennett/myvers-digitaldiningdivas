package Entities;

import java.time.LocalDate;
import java.util.List;

public interface UserFactory {
     User createUser(String username, String password, String type, LocalDate date, String img, List<String> favRestaurants);

     Loggable loginUser(String username, String password, String type, LocalDate date, String img,
                        List<String> favRestaurants);
}
