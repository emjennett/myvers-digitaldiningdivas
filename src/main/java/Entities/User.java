package Entities;

import java.text.SimpleDateFormat;
import java.util.Objects;

public interface User {
    public String getUserName();

    public String getPassword();

    public boolean validPassword();

    public String getCreatedOn();

    public boolean confirmPassword(String pass);

    String getType();
}
