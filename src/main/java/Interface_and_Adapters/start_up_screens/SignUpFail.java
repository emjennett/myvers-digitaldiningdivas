package Interface_and_Adapters.start_up_screens;

public class SignUpFail extends RuntimeException{
    public SignUpFail(String error) {
        super(error);
    }
}
