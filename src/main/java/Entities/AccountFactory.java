package Entities;

import java.time.LocalDate;

public class AccountFactory implements UserFactory{

    /**
     * A request to create a new user.
     * @param username a name associated with the user.
     * @param password to allow the user to keep the account secure.
     */
    @Override
    public User createUser(String username, String password, String type, LocalDate date) {
        if(type == "owner"){
            return new AccountOwner(username, password, date);
        }
        else{
            return new AccountUser(username, password, date);
        }

    }

    /**
     * A request to log in with an account that has been already created.
     * @param username a name associated with the user.
     * @param password to allow access to the users account.
     */
    @Override
    public Loggable loginUser(String username, String password, String type, LocalDate date) {
        if(type == "user") {
            return new AccountUser(username, password, date);
        }
        else{
            return new AccountOwner(username, password, date);
        }
    }


}
