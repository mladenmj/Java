package Distribuzione;

import Oggetti.Elemento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Distributore {
    protected ArrayList<String[]> file;
    protected ArrayList<Elemento> prodotti;
    protected double[] monete = {50, 20, 10, 5};
    protected double soldiInseriti, soldiTotali;
    private String selezione;

    public Distributore(ArrayList<String[]> file) {
        this.file = file;
        this.prodotti = new ArrayList<>();
        this.soldiTotali = 0;
        this.selezione = "";
        creaMenu();
    }

    public abstract void creaMenu();

    public abstract boolean refillDistributore();

    public void acquistaProdotto() {
        for (int i = 0; i < file.size(); i++) {
            System.out.println(i + " " + file.get(i)[1] + " Prezzo:\t" + file.get(i)[2] + " Quantità rimasta: " + prodotti.get(i).qty);
        }

        System.out.println("Selezionare prodotto inserendo il codice: ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader r = new BufferedReader(in);

        try {
            selezione = "";
            String s = r.readLine();
            selezione += s;
            selezione = prodotti.get(Integer.parseInt(selezione)).getNome();
            System.out.println(selezione);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------");

        insertMoney();

        for (int i = 0; i < prodotti.size(); i++) {
            if (selezione.equals(prodotti.get(i).getNome())) {
                purchase(i);
            }
        }
    }

    public void insertMoney() {
        this.soldiInseriti = 0;

        for (int i = 0; i < this.monete.length; i++) {
            System.out.println("Inserire numero monete da " + this.monete[i] + "cent: ");

            try {
                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader r = new BufferedReader(in);

                this.soldiInseriti += (monete[i] * Integer.parseInt(r.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void purchase(int i) {
        double price = prodotti.get(i).getPrezzo() * 100;

        if (prodotti.get(i).isAvailable() && soldiInseriti >= price) {
            soldiTotali += soldiInseriti;
            soldiInseriti -= prodotti.get(i).getPrezzo() * 100;
            prodotti.get(i).qty--;

            System.out.println("Erogo prodotto " + prodotti.get(i).getNome() + "...");
        } else if (! prodotti.get(i).isAvailable()) {
            System.out.println("Prodotto esaurito.");
        } else {
            System.out.println("Credito non sufficiente.");
        }
    }

    public void showMoneyInside() {
        System.out.println("Soldi all'interno: " + (soldiTotali / 100));
    }

    public void resetMonete(){
        this.soldiTotali = 0.0;
    }

    public void testSetNotAvailable(int i) {
        prodotti.get(i).qty = 0;
    }

    public void showAvailableProducts(boolean checkAvailable) {

        if (checkAvailable) {
            System.out.println("Prodotti disponibili:\n--------------------------------------");

            for (int i = 0; i < prodotti.size(); i++) {
                if (prodotti.get(i).isAvailable()) {
                    System.out.println(prodotti.get(i).getNome());
                }
            }
        }

        if (! checkAvailable) {
            System.out.println("Prodotti esauriti:\n-----------------------------------------");

            for (int i = 0; i < prodotti.size(); i++) {
                if (! prodotti.get(i).isAvailable()) {
                    System.out.println(prodotti.get(i).getNome());
                }
            }
        }

        System.out.println("----------------------------------------\n");
    }
}