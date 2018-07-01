package Banca.Conti;

import Banca.Accountable;
import Banca.Conto;

import java.util.ArrayList;
import java.util.List;

public abstract class abstractConto implements Conto {
    private String Iban;
    private String CF;
    private double saldo;
    protected List<Accountable> accountables;

    public abstractConto(String iban, String CF, double saldo) {
        this.CF = CF;
        this.Iban = iban;
        this.saldo = saldo;
        this.accountables = new ArrayList<>();
    }

    @Override
    public boolean operazione(double amount) {
        if(amount >= 0) {
            this.saldo += amount;
            return true;
        }
        else {
            amount = Math.abs(amount);
            if (amount <= saldo) {
                this.saldo -= amount;
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean addAccountable(Accountable acc) {
        return accountables.add(acc);
    }

    public boolean fineMese() {
        for (Accountable acc : accountables) {
            double importo = acc.getImporto();
            boolean esito = operazione(importo);

            if (!esito) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getIban() {
        return this.Iban;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        return "Iban: " + Iban + ";\tIntestatario: " + CF + ";\tSaldo: " + saldo;
    }
}