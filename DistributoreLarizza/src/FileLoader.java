import Distribuzione.DistribBevande;
import Distribuzione.DistribSnack;
import Distribuzione.Distributore;
import Oggetti.Bevanda;
import Oggetti.Snack;

import java.io.*;
import java.util.ArrayList;

public class FileLoader {
    private ArrayList<Snack> snacks;
    private ArrayList<Bevanda> bevande;
    private String fileName;
    private ArrayList<String[]> lettura;

    public FileLoader() {
        this.bevande = new ArrayList<>();
        this.snacks = new ArrayList<>();
        this.lettura = new ArrayList<>();
    }

    public void load() {
        System.out.println("Inserire nome file: ");

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader r = new BufferedReader(in);

        try {
            this.fileName = r.readLine();
            this.fileName = "snack.txt";

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready()) {
                String line = reader.readLine();
                String lineSplit[] = line.split("\t");

                lettura.add(lineSplit);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Distributore creaDistrib() {
        if (fileName.equals("snack.txt")) {
            return new DistribSnack(lettura);
        }
        else {
            return new DistribBevande(lettura);
        }
    }
}