import soluzioneAbitativa.CameraSemplice;
import soluzioneAbitativa.Camere;
import soluzioneAbitativa.Studio;

import java.io.*;

public class fileLoader {
    Residence residence;

    public fileLoader(Residence residence) {
        this.residence = residence;
    }

    public void load(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready()) {
                String line = reader.readLine();
                String lineSplit[] = line.split("\t");

                switch (lineSplit[1]) {
                    case "A":
                        Camere studio = new Studio(lineSplit[0], Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[3]));
                        residence.aggiungiStanza(studio);
                        break;
                    case "B":
                        Camere simpleRoom = new CameraSemplice(lineSplit[0], Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[3]));
                        residence.aggiungiStanza(simpleRoom);
                        break;
                    default:
                        System.err.println("Errore.");
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}