public class Rettangolo extends Forma {
    private double base;
    private double altezza;

    public Rettangolo(Colore c, double base, double altezza) {
        super(c);
        this.base = base;
        this.altezza = altezza;
    }

    public double getArea() {
        return base * altezza;
    }

    public double getPerimetro() {
        return 2 * (base + altezza);
    }

    public String toString() {
        return super.toString() + " Rectangule: " + this.base + " x " + this.altezza + "\n";
    }
}