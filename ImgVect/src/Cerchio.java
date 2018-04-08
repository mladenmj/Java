import java.lang.Math;

public class Cerchio extends Forma {
    private double raggio;

    public Cerchio(Colore c, double ray) {
        super(c);
        this.raggio = ray;
    }

    public double getArea() {
        return Math.PI * (raggio * raggio);
    }

    public double getPerimetro() {
        return 2 * Math.PI * raggio;
    }

    public String toString() {
        return super.toString() + " Circle: " + this.raggio + "\n";
    }
}
