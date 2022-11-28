package Interface_and_Adapters.StartUpScreens;

public class SignUpFail extends RuntimeException{
    public SignUpFail(String error) {
        super(error);
    }
}
