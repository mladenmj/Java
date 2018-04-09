public class testPrinter {
    public static void main(String[] args) {
        inkJetPrinter HP = new inkJetPrinter();
        ImgVect i = new ImgVect(6);

        Forma f = new Quadrato(Colore.RED, 9);
        Forma f2 = new Quadrato(Colore.YELLOW, 5);
        Forma f3 = new Rettangolo(Colore.BLACK, 8, 3);
        Forma f5 = new Rettangolo(Colore.RED, 5, 6);
        Cerchio f4 = new Cerchio(Colore.BLUE, 8);

        i.aggForma(f);
        i.aggForma(f2);
        i.aggForma(f3);
        i.aggForma(f4);
        i.aggForma(f5);

        HP.initCartridge();
        HP.checkCrtrdgLvl(i);
        HP.stampa(i);
        HP.showCrtrdgLevel();
    }
}