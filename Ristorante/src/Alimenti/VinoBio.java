package Alimenti;

public class VinoBio extends Vino implements Biologico {
    private String tracciabilita;
    private static int numBio;

    public VinoBio(String nome, String tipo, String colore, double gradAlcolica) {
        super(nome, tipo, colore, gradAlcolica);
        this.tracciabilita = "VinoBio-" + numBio;
        numBio++;
    }

    @Override
    public String getTracciabilita() {
        return tracciabilita;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + tracciabilita;
    }
}