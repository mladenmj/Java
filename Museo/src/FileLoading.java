import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileLoading {
    private ArrayList<OggettoEsposizione> oggetti;
    private Museo museo;

    public FileLoading(Museo museo) {
        this.oggetti = new ArrayList<>();
        this.museo = museo;
    }

    public void load(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready()) {
                String line = reader.readLine();
                String[] lineSplit = line.split("\t");

                oggetti.add(new OggettoEsposizione(lineSplit[0], Integer.parseInt(lineSplit[1]), lineSplit[2], lineSplit[3]));
            }
            museo.oggetti = oggetti;
            museo.initSale(oggetti);

            reader.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}