package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Account implements Serializable {
    //A class which functions as the base for all account types.
    private String userName; //The username associated with the account.
    private String password; //The password associated with the account.
    private LocalDate date; //Date of the accounts' creation.

    private String img; //User's profile picture
    private List<String> favRestaurants;

    private static final long serialVersionUID = 8843875467083141039L;

    public Account(String name, String pass, LocalDate date, String img, List<String> favRestaurants){
        //Constructor for the account class.
        this.userName = name;
        this.password = pass;
        this.date = date;
        this.img = img;
        this.favRestaurants = favRestaurants;

    }

    public String getImg(){
        return this.img;
    }

    public List<String> getFavRestaurants(){
        return this.favRestaurants;
    }
    public LocalDate getDate(){
        return this.date;
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
    
}
