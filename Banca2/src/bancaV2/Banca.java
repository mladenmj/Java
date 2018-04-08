package bancaV2;

import bancaV2.conti.*;
import java.util.*;

public class Banca {
    private String nome;
    private Map<String, Conto> conti;

    public Banca(String nome) {
        this.nome = nome;
        conti = new LinkedHashMap<>();
    }

    public Conto aggiungiConto(String cf, ContoType type) {
        Conto c = null;

        switch(type) {
            case DEPOSITO:
                c = new ContoDeposito(genIban(), cf, 0.0);
                break;

            case WEB:
                c = new ContoCorrenteWeb(genIban(), cf, 0.0);
                break;

            case CORRENTE:
                c = new ContoCorrente(genIban(), cf, 0.0);
                break;
        }

        conti.put(c.getIban(), c);
        return c;
    }

    public boolean operazione(String iban, double amount) {
        Conto c = conti.get(iban);
        return c.operazione(amount);
    }

    // FineMese, Acoountable, ChangePass, LogIn.....

    public boolean changePass(String iban, String oldPass, String newPass) {
        boolean res = false;
        Conto c = conti.get(iban);

        if (c instanceof ContoCorrenteWeb) {
            res = ((ContoCorrenteWeb) c).setPassword(oldPass, newPass);
        }
        return res;
    }

    public boolean login(String iban, String password) {
        boolean res = false;
        Conto c = conti.get(iban);

        if(c instanceof ContoCorrenteWeb) {
            res = ((ContoCorrenteWeb) c).login(password);
        }
        return res;
    }

    private String genIban() {
        return nome+conti.size();
    }

    public String toString() {
        String s = "\nBanca " + nome + "\n";
        s += "------------\n";
        s += (conti==null?0:conti.size()) + " conti attivi\n";
        s += "------------\n";
        for (Conto c:conti.values()) {
            s += c + "\n";
        }
        s += "------------\n";
        return s + "\n";
    }
}