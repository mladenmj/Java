package partite;

import squadre.Squadra;

public class PartitaCalcio extends Partita {
    Squadra home, away;

    public PartitaCalcio(Squadra home, Squadra away) {
        super();
        new PartitaCalcio(home, away, 0, 0);
    }

    public PartitaCalcio(Squadra home, Squadra away, int homeScore, int awayScore) {
        this.home = home;
        this.away = away;
        homeScore = 0;
        awayScore = 0;
    }
}