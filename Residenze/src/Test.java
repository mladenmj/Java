public class Test {
    public static void main(String[] args) {
        Residence residence = new Residence();

        fileLoader loader = new fileLoader(residence);
        loader.load("struttura1.txt");

        //residence.getCostoCamere();

        //residence.getCostoCamere(12);

        Prenotazione booking = new Prenotazione(residence, "Paolo", 1);
        Prenotazione booking2 = new Prenotazione(residence, "Gianni", 3);
        residence.printAvailable();

//        ResidenceGUI gui = new ResidenceGUI(residence);
//        gui.setVisible(true);
    }
}