public class ContoWeb extends abstractConto {
    private boolean loggedIn;
    private String password;
    private boolean firstlogin;

    public ContoWeb(String Iban, String CF, double saldo) {
        super(Iban, CF, 0.0);
        this.loggedIn = false;
        this.firstlogin = true;
        this.password = "changeme";
    }

    public boolean login(String password) {
        if(password.equals(this.password) && !firstlogin) {
            loggedIn = true;
            firstlogin = false;
        } else
            this.loggedIn = false;

        return this.loggedIn;
    }

    public boolean setPassword(String oldPass, String newPass) {
        if (firstlogin && oldPass.equals(this.password)) {
            this.password = newPass;
            this.firstlogin = false;
            this.loggedIn = false;
            return true;
        } else
            return false;
    }

    @Override
    public boolean operazione(double amount) {
        if (!loggedIn)
            return false;
        else
            return super.operazione(amount);
    }
}
