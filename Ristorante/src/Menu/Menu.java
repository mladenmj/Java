package Menu;

import Alimenti.Alimento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Menu {
    public ArrayList<ElementoMenu> listaMenu;

    public Menu() {
        this.listaMenu = new ArrayList<>();
    }

    public void addElemento(Alimento alimento, double price) {
        ElementoMenu elemento = new ElementoMenu(alimento, price);
        listaMenu.add(elemento);
    }

    public void remElemento(Alimento alimento) {
        ArrayList<ElementoMenu> toRemove = new ArrayList<ElementoMenu>();
        for (ElementoMenu e : listaMenu) {
            if (e.getAlimento().equals(alimento)) {
                toRemove.add(e);
            }
        }

        listaMenu.removeAll(toRemove);
    }

    @Override
    public String toString() {
        String s = "";

        for (ElementoMenu e : listaMenu) {
            s += e.toString();
        }

        return s;
    }

    public void ordinaListaPerPrezzo() {
        Collections.sort(listaMenu, new Comparator<ElementoMenu>() {

            @Override
            public int compare(ElementoMenu t, ElementoMenu t1) {
                double dif = t.getPrezzo() - t1.getPrezzo();
                if (dif > 0) {
                    return 1;
                } else {
                    if (dif < 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
    }
}