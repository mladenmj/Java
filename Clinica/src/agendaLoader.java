import java.io.*;

public class agendaLoader {
    private Agenda agenda;

    public agendaLoader(Agenda agenda) {
        this.agenda = agenda;
    }

    public void load (String FileName) {
        File f = new File(FileName);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));

            while (reader.ready()) {
                String line = reader.readLine();
                String[] lineSplit = line.split("\t");

                Prenotazione p = new Prenotazione(lineSplit[0], lineSplit[1], lineSplit[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}