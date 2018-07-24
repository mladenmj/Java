import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Museo {
    private ArrayList<Sala> sale;
    private int numOggettiSala;
    public ArrayList<OggettoEsposizione> oggetti;

    public Museo() {
        this.sale = new ArrayList<>();
        this.numOggettiSala = 0;
    }

    public void initSale(ArrayList<OggettoEsposizione> oggetti) {
        if (sale.size() == 0)
            sale.add(new Sala(oggetti.get(0).getNomeSala()));

        if (sale.size() != 0) {
            for (OggettoEsposizione oggettiEspo : oggetti) {
                if(! checkIfSalaPresent(oggettiEspo)) {
                    sale.add(new Sala(oggettiEspo.getNomeSala()));
                }
            }
        }
    }

    public void printSale() {
        for(int i = 0; i < sale.size(); i++) {
            System.out.println("Sala: " + sale.get(i).getTipoSala() + "| Numero di pezzi: " +
                            calcNumOggettiSala(sale.get(i), this.oggetti));
        }
    }

    private int calcNumOggettiSala(Sala sala, ArrayList<OggettoEsposizione> oggetti) {
        for(int i = 0; i < oggetti.size(); i++) {
            if (sala.getTipoSala().equals(oggetti.get(i).getNomeSala())) {
                numOggettiSala++;
            }
        }

        int numero = numOggettiSala;
        numOggettiSala = 0;
        return numero;
    }

    private boolean checkIfSalaPresent(OggettoEsposizione oggettoEsposizione) {
        for (int i = 0; i < sale.size(); i++) {
            if (oggettoEsposizione.getNomeSala().equals(sale.get(i).getTipoSala())) {
                return true;
            }
        }

        return false;
    }

    public void stampaOggOrdinati() {
        ordinaOggetti();
        stampaOggetti();
    }

    public void stampaOggetti() {
        System.out.println("\nOggetti: ");

        for (int i = 0; i < oggetti.size(); i++) {
            System.out.println(oggetti.get(i).getNomeSala() + " " + oggetti.get(i).getAnno() + " " + oggetti.get(i).getCodiceID());
        }
    }

    public void ordinaOggetti() {
        Collections.sort(oggetti, (o1, o2) -> {
            int compare = o1.getNomeSala().compareTo(o2.getNomeSala());

            if (compare == 0) {
                int cmp = o1.getAnno() - o2.getAnno();

                if (cmp == 0) {
                    return o1.getCodiceID().compareTo(o2.getCodiceID());
                }

                return cmp;
            }

            return compare;
        });
    }
}