package bancaV2.conti;

public class ContoCorrenteWeb extends ContoCorrente {
    private boolean loggedIn;
    private String password;
    private boolean firstLogin;

    public ContoCorrenteWeb(String iban, String cf, double saldo) {
        super(iban, cf, saldo);
        this.password = "changeme";
        this.loggedIn = false;
        this.firstLogin = true;
    }


    // See again this code because password can be changed only one time.....

    public boolean login(String password) {
        if (firstLogin || password.equals("changeme")) {
            return false;
        }
        else if (password.equals(this.password)) {
            loggedIn = true;
            return true;
        }
        else
            return false;
    }

    public boolean setPassword(String oldPass, String newPass) {
        if(oldPass.equals(this.password)) {
            oldPass = newPass;
            firstLogin = false;
            return true;
        }

        else
            return false;
    }

    // Operazione is working properly.

    public boolean operazione(double amount) {
        if (loggedIn) {
            return super.operazione(amount);
        }
        else {
            System.out.println("Login needed to perform this operation.\n");
            return false;
        }
    }
}