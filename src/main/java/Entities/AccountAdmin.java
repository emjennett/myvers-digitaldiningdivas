package Entities;

public class AccountAdmin extends Account{
    /**
     * An account meant for employees with special administrative privileges.
     * @param name
     * @param pass
     */
    public AccountAdmin(String name, String pass) {
        super(name, pass);
    }
}
