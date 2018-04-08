package bancaV2;

public interface Conto {
    double getSaldo();

    String getIban();

    boolean operazione(double amount);

    // Acoountables e fineMese .....
}