public interface Conto {
    boolean operazione(double amount);
    double getSaldo();
    String getIban();
}