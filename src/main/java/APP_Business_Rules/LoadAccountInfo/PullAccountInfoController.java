package APP_Business_Rules.LoadAccountInfo;

import APP_Business_Rules.RestaurantUseCase.RestaurantInputBoundary;
import APP_Business_Rules.login_user.LoginUserResponseModel;

import java.time.LocalDate;

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



    public LoginUserResponseModel updateBio(String username, String bio, LocalDate date) {

        System.out.println(bio + "1");
        UpdateRequestModel requestModel = new UpdateRequestModel(username, bio, date);
        return userInput.UpdateBio(requestModel);
    }
}
