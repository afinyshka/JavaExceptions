package HW_03.Exceptions;

public class NotAStringException extends NumberFormatException {
    public NotAStringException(String message) {
        super(message);
    }
    
}
