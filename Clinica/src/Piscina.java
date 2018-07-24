public class Piscina extends Struttura {
    public Patologia[] patos = {Patologia.PATO0, Patologia.PATO3, Patologia.PATO4};

    public Piscina(String nome) {
        super(nome);
    }

    public Patologia[] getPatos() {
        return patos;
    }

    @Override
    public String toString() {
        String out = "";

        for (int i = 0; i < patos.length; i++) {
            out += "\t" + patos[i].name();
        }

        return super.toString() + "| Patologie curate: " + out + "\n";
    }
}