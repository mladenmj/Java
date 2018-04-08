public class Quadrato extends Forma {
    private double lato;

    public Quadrato(Colore c, double lato) {
        super(c);
        this.lato = lato;
    }

    public double getArea() {
        return lato * lato;
    }

    public double getPerimetro() {
        return 4 * lato;
    }

    @Override
    public String toString() {
        return super.toString() + " Square: " + this.lato + "\n";
    }
}