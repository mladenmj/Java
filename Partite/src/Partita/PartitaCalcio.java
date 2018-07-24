package Partita;

import risultati.Risultato;
import squadre.Squadra;

public class PartitaCalcio extends Partita {

    public PartitaCalcio(Squadra home, Squadra away) {
        super();
        setRisultato(new Risultato(home, away));
    }
}
