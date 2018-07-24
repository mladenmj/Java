package risultati;

import squadre.Squadra;

public class Risultato {
    private Squadra homeTeam, awayTeam;
    protected int homePoints, awayPoints;

    public Risultato(Squadra homeTeam, Squadra awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homePoints = 0;
        this.awayPoints = 0;
    }
}