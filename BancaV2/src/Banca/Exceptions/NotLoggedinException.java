package Banca.Exceptions;

public class NotLoggedinException extends RuntimeException {
    public NotLoggedinException() {
        super("You have to login");
    }

    public NotLoggedinException(String message) {
        super(message);
    }
}
