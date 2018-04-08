package bancaV2.conti;

public class ContoCorrente extends AbstractConto {

    public ContoCorrente(String iban, String cf, double saldo) {
        super(iban, cf, 0.0);
    }
}