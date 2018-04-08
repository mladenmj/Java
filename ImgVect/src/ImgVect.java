import java.util.Arrays;

public class ImgVect {
    private Forma[] f;
    private final int nMax;
    private int formeIns;

    public ImgVect(int N_MAX) {
        this.nMax = N_MAX;
        f = new Forma[this.nMax];
        this.formeIns = 0;
    }

    public void aggForma(Forma s) {
        if(formeIns < nMax) {
            f[formeIns++] = s;
        }
    }

    public double AreaColore() {
        double area = 0.0;

        for(int i = 0; i < formeIns; i++) {
            area += f[i].getArea();
        }

        return area;
    }

    public double AreaColore(Colore c) {
        double area = 0.0;

        for (int i = 0; i < formeIns; i++) {
            if(f[i].getColore().equals(c)) {
                area += f[i].getArea();
            }
        }

        return area;
    }

    @Override
    public String toString() {
        String s = "";
        for (Forma e : f) {
            if (e != null) {
                s += e;
            }
        }
        return s;
    }

    public void ordinaForme() {
        Arrays.sort(f, 0, formeIns);
    }
}