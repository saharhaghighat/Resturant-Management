package exception;

public class InvalidPass extends RuntimeException{
    private static final String message="Invalid pass!";

    public InvalidPass() {
        super(message);
    }
}
