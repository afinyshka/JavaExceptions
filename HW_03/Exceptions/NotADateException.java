package HW_03.Exceptions;

public class NotADateException extends NumberFormatException {
    public NotADateException(String message) {
        super(message);
    }
}