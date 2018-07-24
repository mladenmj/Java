import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class FileLoader {

    public void getEvents(File f) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(f));
            ArrayList<SportEvent> events = new ArrayList<>();

            while (in.ready()) {
                String line = in.readLine();
                String[] lineSplit = line.split("\t");

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                Date date = dateFormat.parse(lineSplit[2]);
                GregorianCalendar time = new GregorianCalendar();
                time.setTime(date);

                events.add(new SportEvent(lineSplit[0], lineSplit[1], time));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}