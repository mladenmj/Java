package bancaV2.conti;

import bancaV2.Conto;

public class AbstractConto implements Conto {
    private String cf;
    private String iban;
    private double saldo;

    public AbstractConto(String iban, String cf, double saldo) {
        this.cf = cf;
        this.iban = iban;
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean operazione(double amount) {
        if(amount >= 0) {
            this.saldo += amount;
            return true;
        }
        if (amount < 0 && Math.abs(amount) <= saldo) {
            this.saldo += amount;
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "iban: " + iban + ";" + "\tintestatario: " + cf
                + ";" + "\tsaldo: " + saldo;
    }

    // Accountables e fineMese()....
}