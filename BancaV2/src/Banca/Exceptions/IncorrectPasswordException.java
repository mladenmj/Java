package Banca.Exceptions;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super("wrong password");
    }

    public IncorrectPasswordException(String message) {
        super(message);
    }
}
