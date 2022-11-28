package Interface_and_Adapters.StartUpScreens;

public class LoginFail extends RuntimeException{

    public LoginFail(String error){
        super(error);
    }
}
