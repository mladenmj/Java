public class Palestra extends Struttura {
    private Patologia[] patologias = {Patologia.PATO1, Patologia.PATO9, Patologia.PATO6};

    public Palestra(String nome) {
        super(nome);
    }

    public Patologia[] getPatologias() {
        return patologias;
    }

    @Override
    public String toString() {
        String out = "";

        for (int i = 0; i < patologias.length; i++) {
            out += "\t" + patologias[i].name();
        }

        return super.toString() + "| Patologie curate: " + out + "\n";
    }
}
