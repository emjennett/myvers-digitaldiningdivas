package APP_Business_Rules.LoadAccountInfo;

public class PullAcountInteractor implements  PullAccountInputBoundary {

    private String username;

    public PullAcountInteractor(String username){
        this.username = username;


    }
    public String PullAccount(String username){
        UserAccountInfoFile test = new UserAccountInfoFile("./AccountInfo.csv");

        if (!test.findAccountUser(username)){
            test.save(new UserAccountInfoModel(username));
        }

        UserAccountInfoModel model = test.load(username);

        return model.getBio();

    }

    public void UpdateBio(String username, String newbio){
        UserAccountInfoFile file = new UserAccountInfoFile("./AccountInfo.csv");
        UserAccountInfoModel model = file.load(username);
        file.change(model.getUser(), newbio);

    }


}
