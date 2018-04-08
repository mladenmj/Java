public class Test {
    public static void main(String[] args) {
        ImgVect i = new ImgVect(10);

        Forma f = new Quadrato(Colore.RED, 10);
        Forma f2 = new Quadrato(Colore.YELLOW, 5);
        Forma f3 = new Rettangolo(Colore.BLACK, 8, 3);
        Cerchio f4 = new Cerchio(Colore.BLUE, 8);

        i.aggForma(f);
        i.aggForma(f2);
        i.aggForma(f3);
        i.aggForma(f4);

        System.out.println("Area totale: " + i.AreaColore());

        for (Colore c : Colore.values()) {
            System.out.println(c.name() + " area: " + i.AreaColore(c));
        }

        System.out.println(i);

        i.ordinaForme();

        System.out.println("Forme ordinate per area crescente:\n");
        System.out.println(i);
    }
}