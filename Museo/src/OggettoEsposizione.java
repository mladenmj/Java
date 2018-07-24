public class OggettoEsposizione {
    private String descrizione, codiceID, nomeSala;
    private int anno;

    public OggettoEsposizione(String codiceID, int anno, String descrizione, String nomeSala) {
        this.descrizione = descrizione;
        this.codiceID = codiceID;
        this.anno = anno;
        this.nomeSala = nomeSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public String getCodiceID() {
        return codiceID;
    }

    public int getAnno() {
        return anno;
    }
}