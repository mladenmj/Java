package Ristoranti;

import Alimenti.Alimento;
import Alimenti.Vino;
import Menu.Menu;

public class Enoteca extends EsercizioRistorazione {

    public Enoteca(String nome, Menu menu) {
        super(nome, menu);
    }

    @Override
    public void addElemento(Alimento alimento, double price) {
        if (alimento instanceof Vino) {
            this.getMenu().addElemento(alimento, price);
        } else
            System.out.println("Non è un vino, impossibile agiungere.\n");
    }

    @Override
    public void removeElemento(Alimento alimento) {
        this.getMenu().remElemento(alimento);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}