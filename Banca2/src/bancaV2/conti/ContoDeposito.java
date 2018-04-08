package bancaV2.conti;

import bancaV2.Conto;

public class ContoDeposito extends AbstractConto {
    public ContoDeposito(String iban, String cf, double saldo) {
        super(iban, cf, 0.0);
    }

    // AddAccountable.....

    @Override
    public boolean operazione(double amount) {
        if (amount >= 0) {
            super.operazione(amount);
            return true;
        }
        else
            return false;
    }
}