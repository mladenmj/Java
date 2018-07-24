package Menu;

import Alimenti.Alimento;

public class ElementoMenu {
    public Alimento alimento;
    public double prezzo;

    public ElementoMenu(Alimento alimento, double prezzo) {
        this.alimento = alimento;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return alimento.toString() + "\tPrezzo: " + this.prezzo + " €" + "\n";
    }

    public Alimento getAlimento() {
        return alimento;
    }
}