package Entities;

public interface UserFactory {
     User createUser(String username, String password, String type);

     Loggable loginUser(String username, String password, String type);
}
