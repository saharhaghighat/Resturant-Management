package exception;

public class NotfoundUser extends RuntimeException{
    public NotfoundUser(String message) {
        super(message);
    }
}
