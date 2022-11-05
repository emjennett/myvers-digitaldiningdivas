package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class Account {
    //Abstract class which functions as the base for all account types.
    private String UserName; //The username associated with the account.
    private final String password; //The password associated with the account.
    private Date createdOn; //Date of the accounts' creation.

    public Account(String name, String pass){
        //Constructor for the account class.
        this.UserName = name;
        this.password = pass;
        this.createdOn = new Date();
    }

    public String getUserName(){
        //Returns the username of the account.
        return this.UserName;
    }

    public boolean confirmPassword(String pass){
        //Returns a boolean. True if the given string matches the account password, false otherwise.
        return (Objects.equals(this.password, pass));
    }

    public String getCreatedOn(){
        //Returns the date of the account creation in string form.
        SimpleDateFormat formatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatted.format(this.createdOn);
    }
}
