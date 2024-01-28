package APP_Business_Rules.LoadAccountInfo;

import Entities.Restaurant;

import java.time.LocalDate;
import java.util.List;

public class UpdateRequestModel {
    private String username;
    private String bio;
    private LocalDate date;
    private String pic;
    private List<String> favRestaurants;
    private String newRes;
    public UpdateRequestModel(String username, String bio, LocalDate date, String pic, List<String> favRestaurants, String newRes){

        this.username = username;
        this.bio = bio;
        this.date = date;
        this.pic = pic;
        this.newRes = newRes;
        this.favRestaurants = favRestaurants;
    }

    public String getUsername(){return this.username;}

    public String getBio(){return this.bio;}

    public LocalDate getDate() { return this.date;

    }

    public String getPic() { return this.pic;
    }


    public List<String> getFavRestaurants() {
        return this.favRestaurants;
    }

    public String getNewRes() { return this.newRes;
    }
}
