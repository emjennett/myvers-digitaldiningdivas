package Entities;

public interface UserFactory {
     User createUser(String username, String password);

     Loggable loginUser(String username, String password);
}
