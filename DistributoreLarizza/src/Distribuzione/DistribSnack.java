package Distribuzione;

import Oggetti.Snack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DistribSnack extends Distributore {

    public DistribSnack(ArrayList<String[]> file) {
        super(file);
    }

    @Override
    public void creaMenu() {
        for (int i = 0; i < file.size(); i++) {
            prodotti.add(new Snack(file.get(i)[0], file.get(i)[1], Double.parseDouble(file.get(i)[2])));
        }
    }

    @Override
    public boolean refillDistributore() {
        for (int i = 0; i < super.prodotti.size(); i++) {
            prodotti.get(i).qty = 20;
        }

        return false;
    }
}