public interface Conto {
    boolean operazione(double amount);
    String getIban();
    double getSaldo();
}