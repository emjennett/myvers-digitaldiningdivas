package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Account implements Serializable {
    //A class which functions as the base for all account types.
    private String userName; //The username associated with the account.
    private String password; //The password associated with the account.
    private Date createdOn; //Date of the accounts' creation.

    public Account(String name, String pass){
        //Constructor for the account class.
        this.userName = name;
        this.password = pass;
        this.createdOn = new Date();
    }

    public String getUserName(){
        //Returns the username of the account.
        return this.userName;
    }
    public String getPassword(){
        //Returns the password of the account.
        return this.password;
    }
    public boolean confirmPassword(String pass){
        //Returns a boolean. True if the given string matches the account password, false otherwise.
        return (Objects.equals(this.getPassword(), pass));
    }

    public String getCreatedOn(){
        //Returns the date of the account creation in string form.
        SimpleDateFormat formatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatted.format(this.createdOn);
    }
}
