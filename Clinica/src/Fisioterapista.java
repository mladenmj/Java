public class Fisioterapista {
    private String nome, cognome;
    private String ID;
    private static int numFisio = 1;

    public Fisioterapista(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.ID = "ID" + numFisio++;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return this.ID + " ";
    }
}