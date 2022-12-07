package Interface_and_Adapters.start_up_screens;

public class LoginFail extends RuntimeException{

    public LoginFail(String error){
        super(error);
    }
}
