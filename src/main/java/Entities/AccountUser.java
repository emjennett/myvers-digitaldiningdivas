package Entities;

import java.util.Objects;

public class AccountUser extends Account implements User {
    public AccountUser(String name, String pass) {
        super(name, pass);
    }

    @Override
    public boolean validPassword() {
        return this.getPassword().length() >= 6;
    }
}
