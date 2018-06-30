public abstract class abstractConto implements Conto {
    private String Iban;
    private String CF;
    private double saldo;

    public abstractConto(String iban, String CF, double saldo) {
        this.CF = CF;
        this.Iban = iban;
        this.saldo = saldo;
    }

    @Override
    public boolean operazione(double amount) {
        if(amount >= 0) {
            this.saldo += amount;
            return true;
        }
        else {
            if (-amount <= saldo) {
                saldo += amount;
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String getIban() {
        return this.Iban;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        return "Iban: " + Iban + ";\tIntestatario: " + CF + ";\tSaldo: " + saldo;
    }
}