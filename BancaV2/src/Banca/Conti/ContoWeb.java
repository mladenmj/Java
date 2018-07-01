package Banca.Conti;

import Banca.Exceptions.IncorrectPasswordException;
import Banca.Exceptions.InvalidOperationException;
import Banca.Exceptions.NotLoggedinException;

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
        this.loggedIn = false;

        if (password.equals(this.password)) {
            if(!firstlogin) {
                this.loggedIn = true;
                this.firstlogin = false;
            } else {
                throw new InvalidOperationException("please change the default password");
            }
        } else {
            throw new IncorrectPasswordException();
        }

        return loggedIn;
    }

    public boolean setPassword(String oldPass, String newPass) {
        try {
            if (firstlogin && oldPass.equals(this.password)) {
                this.password = newPass;
                this.firstlogin = false;
                this.loggedIn = false;
                return true;
            } else
                throw new InvalidOperationException("Conto " + this.getIban() + ": password change not allowed ");
        } catch (InvalidOperationException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean operazione(double amount) {
        if (!loggedIn)
            throw new NotLoggedinException();
        else
            return super.operazione(amount);
    }
}
