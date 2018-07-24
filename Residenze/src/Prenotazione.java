import soluzioneAbitativa.Camere;

import java.util.ArrayList;

public class Prenotazione {
    private int numPers, roomNumber;
    private String nome;

    public Prenotazione(Residence residence, String nomeAbitante, int numPers) {
        this.numPers = numPers;
        this.nome = nomeAbitante;
        roomNumber = checkIfFreeRoom(residence);
    }

    private int checkIfFreeRoom(Residence residence) {
        ArrayList<Camere> rooms = residence.getStructures();

        for (int i = 0; i < rooms.size(); i++) {
            if (numPers <= rooms.get(i).getnMaxPers() && rooms.get(i).isAvailable()) {
                rooms.get(i).setAvailable(false);
                return i;
            }
        }

        return -1;
    }

    public int getNumPers() {
        return numPers;
    }

    public void setNumPers(int numPers) {
        this.numPers = numPers;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}