package exceptions;

// Custom Exception for shelf boundaries
public class InvalidLocationException extends RuntimeException {
    public InvalidLocationException(String message) {
        super(message);
    }
}
