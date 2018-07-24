import Partita.PartitaCalcio;
import squadre.Squadra;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        FileLoader events = new FileLoader();
        String path = "calcio.txt";

        Squadra Juve = new Squadra("Juventus", "JUV");
        Squadra Roma = new Squadra("Roma", "ROM");

        PartitaCalcio juveroma = new PartitaCalcio(Juve, Roma);

        events.getEvents(new File(path));

//        TabelloneGUI footballGUI = new TabelloneGUI();
//        footballGUI.setVisible(true);
    }
}