package APP_Business_Rules.create_user;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CreateUserRequestModel {

    private String username;

    private String password;

    private String dup_password;

    private String type;

    private String img;
    private LocalDate date;
    private List<String> favRestaurants;


    /**
     * The model that will take the necessary information to create a user.
     * @param username chosen from input.
     * @param password chosen from input.
     * @param dup_password chosen from input.
     */
    public CreateUserRequestModel(String username, String password, String dup_password, String type,LocalDate date, String img, List<String> favRestaurants){

        this.username = username.strip() ;
        this.password = password;
        this.dup_password = dup_password;
        this.type = type;
        this.date = date;
        this.img = img;
        this.favRestaurants = favRestaurants;

    }

    public String getUsername(){return this.username;}

    public String getPassword(){return this.password;}

    public String getDup_password(){return this.dup_password;}

    public String getType(){return this.type;}

    public boolean validPassword() {
        return password.length() >= 6;
    }

    public LocalDate getDate() { return this.date;
    }

    public String getImg(){
        return this.img;
    }

    public List<String> getFavRestaurants() { return this.favRestaurants;
    }
}
