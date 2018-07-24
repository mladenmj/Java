package Partita;

public class PartitaPallavolo extends Partita {
    private int homeTeamPts, awayTeamPts, currentSet;
    private int homeWonSets, awayWonSets, homeTimeouts, awayTimeouts;

    public PartitaPallavolo(String homeTeamName, String awayTeamName) {
        super();
        this.awayTeamPts = 0;
        this.homeTeamPts = 0;
        this.awayTimeouts = 0;
        this.homeTimeouts = 0;
        this.homeWonSets = 0;
        this.awayWonSets = 0;
    }
}