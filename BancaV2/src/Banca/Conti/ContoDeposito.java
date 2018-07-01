package Banca.Conti;

import Banca.Accountable;
import Banca.Exceptions.InvalidOperationException;
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
            throw new InvalidOperationException();
    }

    @Override
    public boolean addAccountable(Accountable acc) {
        if (acc.getType() == AccountableType.ADDEBITO)
            throw new InvalidOperationException("Accountable not allowed for this account.");
        else
            super.addAccountable(acc);
        return true;
    }
}