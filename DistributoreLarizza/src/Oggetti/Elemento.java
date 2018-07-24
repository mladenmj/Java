package Oggetti;

public abstract class Elemento {
    private String codice, nome;
    private double prezzo;
    public int qty;

    public Elemento(String codice, String nome, double prezzo) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAvailable() {
        if (this.qty == 0)
            return false;

        return true;
    }
}