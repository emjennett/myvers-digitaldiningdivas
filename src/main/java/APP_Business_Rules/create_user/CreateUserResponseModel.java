package APP_Business_Rules.create_user;

public class CreateUserResponseModel {

    String login;


    public CreateUserResponseModel(String loginmsg) {
        this.login = loginmsg;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String loginmsg) {
        this.login = loginmsg;
    }
}
