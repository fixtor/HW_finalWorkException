public class UserIsNullException extends Exception {

    public UserIsNullException(String message, Exception e) {
        super(message, e);
    }
}