package APP_Business_Rules.create_user;

public class CreateUserResponseModel {

    String login;

    //Optional message loginmsg can be stored for testing purposes.
    public CreateUserResponseModel(String loginmsg) {
        this.login = loginmsg;
    }


}
