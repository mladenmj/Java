package Banca;

import Banca.Conti.*;

import java.util.*;

public class Banca {
    public String nome;
    public Map<String, Conto> accounts;

    public Banca(String nome) {
        this.nome = nome.toUpperCase();
        accounts = new LinkedHashMap<>();
    }

    public Conto aggiungiConto(String cf, ContoType type) {
        Conto c = null;
        switch(type) {
            case CORRENTE:
                c = new ContoCorrente(generateIban(), cf, 0.0);
                break;
            case WEB:
                c = new ContoWeb(generateIban(), cf, 0.0);
                break;
            case DEPOSITO:
                c = new ContoDeposito(generateIban(), cf, 0.0);
                break;
        }

        accounts.put(c.getIban(), c);
        return c;
    }

    public boolean operazione(String Iban, double amount) {
        Conto c = accounts.get(Iban);
        return c.operazione(amount);
    }

    public void getSaldo(String Iban) {
        Conto c = accounts.get(Iban);
        System.out.println(c.getSaldo());
    }

    private String generateIban() {
        return this.nome + accounts.size();
    }

    public boolean changePass(String Iban, String oldPass, String newPass) {
        boolean result = false;
        Conto c = accounts.get(Iban);

        if (c instanceof ContoWeb) {
            result = ((ContoWeb) c).setPassword(oldPass, newPass);
        }

        return result;
    }

    public boolean logIn(String Iban, String password) {
        boolean result = false;
        Conto c = accounts.get(Iban);

        if(c instanceof ContoWeb) {
            result = ((ContoWeb) c).login(password);
        }

        return result;
    }

    public void fineMese() {
        for (Conto c : accounts.values()) {
            c.fineMese();
        }
    }

    public boolean addAccountable(String Iban, Accountable accountable) {
        Conto c = accounts.get(Iban);

        return c.addAccountable(accountable);
    }

    public String toString() {
        String s = "\nBanca " + nome + "\n";
        s += "------------\n";
        s += (accounts == null ? 0 : accounts.size()) + " conti attivi\n";
        s += "------------\n";
        for (Conto c : accounts.values()) {
            s += c + "\n";
        }
        s += "------------\n";
        return s + "\n";
    }
}