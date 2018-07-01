package Banca;

public interface Conto {
    boolean operazione(double amount);
    String getIban();
    double getSaldo();

    boolean addAccountable(Accountable acc);
    boolean fineMese();
}