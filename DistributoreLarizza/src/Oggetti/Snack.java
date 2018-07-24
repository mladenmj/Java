package Oggetti;

public class Snack extends Elemento {
    public Snack(String codice, String nome, double prezzo) {
        super(codice, nome, prezzo);
        super.qty = 20;
    }
}