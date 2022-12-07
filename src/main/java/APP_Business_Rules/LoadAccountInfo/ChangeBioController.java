package APP_Business_Rules.LoadAccountInfo;

public class ChangeBioController {
    private String username;

    private String newbio;




    public ChangeBioController(String username, String newbio) {
        this.username = username;
        this.newbio = newbio;
    }
    /**
     * ChangeBioController:
     * method that allows the user to change their bio by changing the UserAccountInfomodel in the csv file.
     *
     */

    public void UpdateBio(){
        PullAccountInputBoundary User = new PullAcountInteractor(username);
        User.UpdateBio(username, newbio);

    }



}
