package Ristoranti;

import Alimenti.Alimento;
import Menu.Menu;

public class Ristorante extends EsercizioRistorazione {

    public Ristorante(String nome, Menu menu) {
        super(nome, menu);
    }

    @Override
    public void addElemento(Alimento alimento, double price) {
        this.getMenu().addElemento(alimento, price);
    }

    @Override
    public void removeElemento(Alimento alimento) {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}