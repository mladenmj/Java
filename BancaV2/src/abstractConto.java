public abstract class abstractConto implements Conto {
    public String Iban;
    public String CF;
    public double saldo;

    @Override
    public String getIban() {
        return null;
    }

    @Override
    public double getSaldo() {
        return 0;
    }
}