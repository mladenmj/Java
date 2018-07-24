package soluzioneAbitativa;

import servizi.Servizio;

public class CameraSemplice extends Camere {
    public CameraSemplice(String id, int m2, int nMaxPers) {
        super(id, m2, nMaxPers);
    }

    @Override
    public int calcoloCosto() {
        int costoVar = super.m2 * 8;
        int costoServizi = getCostoServizi();

        return super.costoFisso + costoVar + costoServizi;
    }

    private int getCostoServizi() {

        return 0;
    }

    @Override
    public String toString() {
        String disp = "";

        if (super.isAvailable()) {
            disp += "disponibile";
        }
        else {
            disp += "non disponibile";
        }

        return super.toString() + this.getId() + " " + disp;
    }
}