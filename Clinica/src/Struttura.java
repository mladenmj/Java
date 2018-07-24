import java.util.ArrayList;

public abstract class Struttura {
    private String nome;
    private ArrayList<Fisioterapista> doctors;

    public Struttura(String nome) {
        this.nome = nome;
        this.doctors = new ArrayList<>();
    }

    public boolean addDoctor(Fisioterapista fisio) {
        if (doctors.size() != 0) {
            for (Fisioterapista f : doctors) {
                if (f.getID().equals(fisio.getID())) {
                    return false;
                }
            }
        }

        doctors.add(fisio);
        return true;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        String out = "";

        for (int i = 0; i < doctors.size(); i++) {
            out += doctors.get(i).toString();
        }

        return "Nome struttura: " + getNome() + " | Dottori: " + out;
    }
}