public abstract class Forma implements Comparable {
    private Colore c;

    public Forma(Colore c) {
        this.c = c;
    }

    public Colore getColore() {
        return c;
    }

    abstract double getArea();
    abstract double getPerimetro();

    public String toString() {
        return "" + c.name();
    }

    public int compareTo(Object o) {
        if (this.getArea() < ((Forma) o).getArea()) {
            return -1;
        }

        else if (this.getArea() > ((Forma) o).getArea()) {
            return +1;
        }

        return 0;
    }
}