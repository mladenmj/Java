public class Tester {
    public static void main(String[] args) {
        ImgVect i1 = new ImgVect(7);

        Cerchio c = new Cerchio(Colore.RED, 1);
        Quadrato q = new Quadrato(Colore.BLUE, 5);
        Rettangolo r = new Rettangolo(Colore.YELLOW, 3, 5);
        Rettangolo r2 = new Rettangolo(Colore.BLUE, 3, 5);
        Forma f = new Quadrato(Colore.RED, 3);

        i1.aggForma(c);
        i1.aggForma(q);
        i1.aggForma(r);
        i1.aggForma(r2);
        i1.aggForma(f);

        System.out.println("N forme: " + i1.formeIns);
        System.out.println("Area totale: " + i1.calcArea());
        System.out.println("Area Rosso: " + i1.calcArea(Colore.RED));
        System.out.println("Area Nero: " + i1.calcArea(Colore.BLACK));
        System.out.println("Area Giallo: " + i1.calcArea(Colore.YELLOW));
        System.out.println("Area Blu: " + i1.calcArea(Colore.BLUE));

        System.out.println("Info: " + i1);

        i1.ordinaForme();

        System.out.println("Ordina forme: " + i1);
    }
}
