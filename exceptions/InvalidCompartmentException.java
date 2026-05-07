package exceptions;

public class InvalidCompartmentException extends RuntimeException {
    public InvalidCompartmentException(String message) {
        super(message);
    }
}
