import Alimenti.Carne;
import Alimenti.Vino;
import Menu.Menu;

import java.io.*;

public class menuLoader {
    private Menu menu;

    public menuLoader(Menu menu) {
        this.menu = menu;
    }

    public void load(String fileName) {
        File inputFile = new File(fileName);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            while(reader.ready()) {
                String line = reader.readLine();
                String[] lineSplit = line.split("\t");

                switch (Integer.parseInt(lineSplit[0])) {
                    case 0:
                        Carne carne = new Carne(lineSplit[1], lineSplit[2], lineSplit[3]);
                        menu.addElemento(carne, Double.parseDouble(lineSplit[4]));
                        break;
                    case 1:
                        Vino vino = new Vino(lineSplit[1], lineSplit[3], lineSplit[4], Double.parseDouble(lineSplit[2]));
                        menu.addElemento(vino, Double.parseDouble(lineSplit[5]));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}