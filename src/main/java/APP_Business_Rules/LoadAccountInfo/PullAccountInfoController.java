package APP_Business_Rules.LoadAccountInfo;

public class PullAccountInfoController {
    private String username;


    public PullAccountInfoController(String username) {
        this.username = username;
    }

    public String GetBio(){
        PullAccountInputBoundary User = new PullAcountInteractor(username);
        return User.PullAccount(username);

    }



}
