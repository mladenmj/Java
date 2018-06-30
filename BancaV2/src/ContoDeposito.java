public class ContoDeposito extends abstractConto {

    @Override
    public boolean operazione(double amount) {
        if(amount >= 0) {
            return true;
        }

        return false;
    }
}