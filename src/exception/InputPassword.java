package exception;

public class InputPassword extends RuntimeException {
    private static final String message="Invalid input";

    public InputPassword() {
        super(message);
    }
}
