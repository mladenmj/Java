package Banca.Exceptions;

public class InvalidIbanException extends RuntimeException {
    public InvalidIbanException() {
        super("iban not found");
    }

    public InvalidIbanException(String message) {
        super(message);
    }
}
