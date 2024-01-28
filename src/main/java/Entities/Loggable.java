package Entities;

import java.time.LocalDate;
import java.util.List;

public interface Loggable {

    String getUserName();

    String getType();
    LocalDate getDate();
    List<String> getFavRestaurants();
}
