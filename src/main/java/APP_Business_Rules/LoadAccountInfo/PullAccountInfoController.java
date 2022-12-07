package APP_Business_Rules.LoadAccountInfo;

public class PullAccountInfoController {
    private String username;


    public PullAccountInfoController(String username) {
        this.username = username;
    }

    /**
     * GetBio:
     * methold that allows the user to change to access their bio by accessing the UserAccountInfomodel in the csv file.
     *
     * @return whether the user exists
     */

    public String GetBio(){
        PullAccountInputBoundary User = new PullAcountInteractor(username);
        return User.PullAccount(username);

    }



}
