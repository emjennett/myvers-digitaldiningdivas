package Entities;

import java.time.LocalDate;

public interface UserFactory {
     User createUser(String username, String password, String type, LocalDate date);

     Loggable loginUser(String username, String password, String type, LocalDate date);
}
