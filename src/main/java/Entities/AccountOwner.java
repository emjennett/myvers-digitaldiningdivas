package Entities;

public class AccountOwner extends Account{
    /**
     * An account meant for owners of restaurants.
     * @param name
     * @param pass
     */
    public AccountOwner(String name, String pass) {
        super(name, pass);
    }
}
