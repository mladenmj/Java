package Banca.Conti;

import Banca.Accountable;
import Banca.accountable.AccountableType;

public class ContoDeposito extends abstractConto {

    public ContoDeposito(String Iban, String CF, double saldo) {
        super(Iban, CF, 0.0);
    }

    @Override
    public boolean operazione(double amount) {
        if(amount > 0) {
            return super.operazione(amount);
        } else
            return false;
    }

    @Override
    public boolean addAccountable(Accountable acc) {
        if (acc.getType() == AccountableType.ACCREDITO)
            return accountables.add(acc);
        else
            return false;
    }
}