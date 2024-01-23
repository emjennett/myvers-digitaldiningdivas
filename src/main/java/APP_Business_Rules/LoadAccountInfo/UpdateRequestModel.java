package APP_Business_Rules.LoadAccountInfo;

import java.time.LocalDate;

public class UpdateRequestModel {
    private String username;
    private String bio;
    private LocalDate date;
    public UpdateRequestModel(String username, String bio, LocalDate date){

        this.username = username;
        this.bio = bio;
        this.date = date;
    }

    public String getUsername(){return this.username;}

    public String getBio(){return this.bio;}

    public LocalDate getDate() { return this.date;

    }
}
