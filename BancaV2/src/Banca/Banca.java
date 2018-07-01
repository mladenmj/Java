package Banca;

import Banca.Conti.*;
import Banca.Exceptions.IncorrectPasswordException;
import Banca.Exceptions.InvalidIbanException;
import Banca.Exceptions.InvalidOperationException;
import Banca.Exceptions.NotLoggedinException;

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
        Conto c = null;

        try {
            c = getConto(Iban);
            return c.operazione(amount);
        } catch (InvalidOperationException | InvalidIbanException | NotLoggedinException e) {
            System.err.println("Conto " + Iban + ": " + e.getMessage());
        }

        return false;
    }

    private Conto getConto(String iban) {
        if (accounts.containsKey(iban)) {
            return accounts.get(iban);
        } else {
            throw new InvalidIbanException(iban + " not valid");
        }
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
        Conto c = null;

        try {
            c = getConto(Iban);

            if(c instanceof ContoWeb) {
                result = ((ContoWeb) c).login(password);
            }
            return result;
        } catch (InvalidIbanException | InvalidOperationException e) {
            System.err.println("Conto " + Iban + ": " + e.getMessage());
        } catch (IncorrectPasswordException e) {
            System.err.println("Password non corretta: " + e.getMessage());
        }

        return false;
    }

    public void fineMese() {
        for (Conto c : accounts.values()) {
            c.fineMese();
        }
    }

    public boolean addAccountable(String Iban, Accountable accountable) {
        Conto c = null;

        try {
            c = getConto(Iban);
            return c.addAccountable(accountable);
        } catch (InvalidIbanException | InvalidOperationException e) {
            System.err.println("Conto " + Iban + ": " + e.getMessage());
        }

        return true;
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