package Distribuzione;

import Oggetti.Bevanda;

import java.util.ArrayList;

public class DistribBevande extends Distributore {
    public DistribBevande(ArrayList<String[]> file) {
        super(file);
    }

    @Override
    public void creaMenu() {
        for (int i = 0; i < file.size(); i++) {
            prodotti.add(new Bevanda(file.get(i)[0], Integer.parseInt(file.get(i)[1]),
                                    file.get(i)[2], Double.parseDouble(file.get(i)[3])));
        }
    }

    @Override
    public boolean refillDistributore() {
        for (int i = 0; i < prodotti.size(); i++) {
            prodotti.get(i).qty = 500;
        }

        return false;
    }
}