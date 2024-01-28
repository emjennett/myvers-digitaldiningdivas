package Entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public interface User {
    public String getUserName();

    public String getPassword();

    public boolean validPassword();
    

    public boolean confirmPassword(String pass);

    String getType();

    LocalDate getDate();

    String getImg();

    List<String> getFavRestaurants();
}
