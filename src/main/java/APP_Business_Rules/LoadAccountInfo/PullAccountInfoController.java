package APP_Business_Rules.LoadAccountInfo;

import APP_Business_Rules.login_user.LoginUserResponseModel;

import java.time.LocalDate;
import java.util.List;

public class PullAccountInfoController {
    final PullAccountInputBoundary userInput;


    public PullAccountInfoController(PullAccountInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * GetBio:
     * methold that allows the user to change to access their bio by accessing the UserAccountInfomodel in the csv file.
     *
     * @return whether the user exists
     */



    public LoginUserResponseModel updateAccount(String username, String bio, String type, LocalDate date, String pic, List<String> favRestaurants, String resName) {

        UpdateRequestModel requestModel = new UpdateRequestModel(username, bio, type, date, pic, favRestaurants, resName);
        return userInput.UpdateBio(requestModel);
    }

    public LoginUserResponseModel removeFav(String username, String bio, String type, LocalDate date, String pic, List<String> favRestaurants, String resName) {
        UpdateRequestModel requestModel = new UpdateRequestModel(username, bio, type, date, pic, favRestaurants, resName);
        return userInput.removeFav(requestModel);
    }
}
