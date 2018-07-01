package Banca.Exceptions;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException() {
        super("illegal operation");
    }

    public InvalidOperationException(String message) {
        super(message);
    }
}
