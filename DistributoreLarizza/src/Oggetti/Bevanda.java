package Oggetti;

public class Bevanda extends Elemento {
    private int qtyUsed;

    public Bevanda(String codice, int qtyUsed, String nome, double prezzo) {
        super(codice, nome, prezzo);
        this.qtyUsed = qtyUsed;
        this.qty = 500;
    }
}