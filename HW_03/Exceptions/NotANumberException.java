package HW_03.Exceptions;

public class NotANumberException extends NumberFormatException {
    public NotANumberException(String message) {
        super(message);
    }
}
