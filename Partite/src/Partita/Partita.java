package Partita;

import risultati.Risultato;

public abstract class Partita {
    private Risultato risultato;
    private boolean finita;

    public Partita() {
        this.finita = false;
    }

    public boolean isFinita() {
        return finita;
    }

    public void setFinita(boolean finita) {
        this.finita = true;
    }

    public void setRisultato(Risultato risultato) {
        this.risultato = risultato;
    }
}