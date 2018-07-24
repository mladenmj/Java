import java.util.ArrayList;

public class Clinica {
    private String nome;
    private Agenda agenda;
    private ArrayList<Struttura> strutturas;

    public Clinica(String nome, Agenda agenda) {
        this.nome = nome;
        this.agenda = agenda;
        this.strutturas = new ArrayList<>();
    }



    public String getNome() {
        return nome;
    }

    public ArrayList<Struttura> getStrutturas() {
        return strutturas;
    }

    public boolean addStructure(Struttura struct) {
        if (strutturas.size() != 0) {
            for (Struttura s : strutturas) {
                if (s.getNome().equals(struct.getNome())) {
                    return false;
                }
            }
        }

        strutturas.add(struct);
        return true;
    }

    public void findStructure() {

    }

    @Override
    public String toString() {
        String out = "Clinica: " + getNome() + "\n";

        if (strutturas.size() == 0)
            return out + "Nessuna struttura presente.\n";

        for (int i = 0; i < strutturas.size(); i++) {
            out += strutturas.get(i).toString();
        }

        return out;
    }
}