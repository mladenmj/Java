public class ContoCorrente extends abstractConto {

    @Override
    public boolean operazione(double amount) {
        if (amount > 0 || -amount < super.getSaldo()) {
            return true;
        }

        return false;
    }
}