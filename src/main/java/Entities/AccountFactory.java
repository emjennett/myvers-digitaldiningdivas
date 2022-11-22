package Entities;

public class AccountFactory implements UserFactory{

    @Override
    public User createUser(String username, String password) {
        return new AccountUser(username, password);
    }
}
