package Ristoranti;

import Alimenti.Alimento;
import Menu.Menu;

public abstract class EsercizioRistorazione {
    String nome;
    Menu menu;

    public EsercizioRistorazione(String nome, Menu menu) {
        this.nome = nome;
        this. menu = menu;
    }

    public abstract void addElemento(Alimento alimento, double price);
    public abstract void removeElemento(Alimento alimento);

    public String getNome() {
        return nome;
    }

    public Menu getMenu() {
        return menu;
    }

    public void ordinaMenuPerPrezzo() {
        menu.ordinaListaPerPrezzo();
    }

    @Override
    public String toString() {
        return getNome() + "\n" + menu.toString();
    }
}