import soluzioneAbitativa.Camere;

import java.util.ArrayList;

public class Residence {
    private int numCamere = 0;
    private ArrayList<Camere> structures;

    public Residence() {
        this.structures = new ArrayList<>();
    }

    public ArrayList<Camere> getStructures() {
        return structures;
    }

    public void aggiungiStanza(Camere room) {
        structures.add(room);
        numCamere++;
    }

    public void getCostoCamere() {

        for (Camere c : structures) {
            System.out.println(c.getId() + ": " + c.calcoloCosto() + "€");
        }
    }

    public void getCostoCamere(int idCamera) {
        String id = "" + idCamera;

        for (int i = 0; i < structures.size(); i++) {
            if (id.equals(structures.get(i).getId())) {
                System.out.println("Costo camera " + id + ": " + structures.get(i).calcoloCosto() + "€");
            }
        }
    }

    @Override
    public String toString() {
        String out = "Camere:\n";
        for (int i = 0; i < structures.size(); i++) {
            out += structures.get(i).toString();
        }

        return "Residence\n" + out;
    }

    public void printAvailable() {
        String out = "";

        for (int i = 0; i < structures.size(); i++) {
            out += structures.get(i).toString() + "\n";
        }

        System.out.println(out);
    }
}