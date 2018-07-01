package Banca.accountable;

public class AbbonamentoSky extends AbstractAccountable {
    public static final double COSTO_INTR = 19;
    public static final double COSTO_CINEMA = 15;
    public static final double COSTO_SPORT = 15;
    public static final double COSTO_EVENTO = 5;
    private boolean hasIntrattenimento, hasSport, hasCinema;
    private int nEventi;

    public AbbonamentoSky(boolean hasIntrattenimento, boolean hasSport, boolean hasCinema) {
        super(AccountableType.ADDEBITO);
        this.hasIntrattenimento = hasIntrattenimento;
        this.hasSport = hasSport;
        this.hasCinema = hasCinema;
    }

    public void addEvent() {
        nEventi++;
    }

    @Override
    public double getImporto() {
        double costo = 0;

        if (hasCinema)
            costo += COSTO_CINEMA;
        if (hasSport)
            costo += COSTO_SPORT;
        if (hasIntrattenimento)
            costo += COSTO_INTR;

        costo += nEventi * COSTO_EVENTO;
        nEventi = 0;

        return -costo;
    }
}
