import java.util.ArrayList;

public class Sala {
    private ArrayList<OggettoEsposizione> oggetti;
    private String tipoSala;

    public Sala(String tipoSala) {
        this.oggetti = new ArrayList<>();
        this.tipoSala = tipoSala;
    }

    public String getTipoSala() {
        return tipoSala;
    }
}