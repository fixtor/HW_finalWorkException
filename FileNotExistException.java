public class FileNotExistException extends Exception {

    public FileNotExistException(String message, Exception e) {
        super(message, e);
    }
}