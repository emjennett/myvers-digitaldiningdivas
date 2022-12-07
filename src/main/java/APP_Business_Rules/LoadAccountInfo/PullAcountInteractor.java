package APP_Business_Rules.LoadAccountInfo;

public class PullAcountInteractor implements  PullAccountInputBoundary {

    private String username;

    public PullAcountInteractor(String username){
        this.username = username;


    }

    /**
     * PullAccount:
     * methold that accesses the UserAccountInfomodel in the csv file.
     * if the user is logging in for the fist time,the UserAccountInfomodel won't exist and a
     * new UserAccountInfomodel will be created and entered into the csv file.
     *
     * @param username the username of the account
     *
     * @return  the bio of the said account
     */
    public String PullAccount(String username){
        UserAccountInfoFile test = new UserAccountInfoFile("./AccountInfo.csv");

        if (!test.findAccountUser(username)){
            test.save(new UserAccountInfoModel(username));
        }

        UserAccountInfoModel model = test.load(username);

        return model.getBio();

    }
    /**
     * UpdateBio:
     * methold that accesses the UserAccountInfomodel in the csv file. and updates the bio of the UserAccountInfomodel
     * and saves it into the csv file
     *
     * @param username the username of the account
     * @param newbio the new bio that will be saved
     *
     */


    public void UpdateBio(String username, String newbio){
        UserAccountInfoFile file = new UserAccountInfoFile("./AccountInfo.csv");
        UserAccountInfoModel model = file.load(username);
        file.change(model.getUser(), newbio);

    }


}
