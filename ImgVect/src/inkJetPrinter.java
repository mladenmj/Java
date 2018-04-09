import java.awt.*;

public class inkJetPrinter {
    private final int MAXLEVEL;
    private int[] cartridge;

    public inkJetPrinter() {
        MAXLEVEL = 100;
        this.cartridge = new int[Colore.values().length];
        initCartridge();
    }

    public void initCartridge() {
        for (Colore c : Colore.values()) {
            this.cartridge[c.ordinal()] = MAXLEVEL;
        }
    }

    public void changeCartridge(Colore c) {
        cartridge[c.ordinal()] = MAXLEVEL;
    }

    public boolean checkCrtrdgLvl(ImgVect i) {
        for(Colore c : Colore.values()) {
            if(i.AreaColore(c) > this.cartridge[c.ordinal()]) {
                return false;
            }
        }

        return true;
    }

    public void stampa(ImgVect i) {
        if(checkCrtrdgLvl(i)) {
            for (Colore c : Colore.values()) {
                cartridge[c.ordinal()] -= i.AreaColore(c);
            }

            System.out.println("Stampa avvenuta con successo.\n");
        }

        else
            System.out.println("Livello di inchiostro non sufficiente per stampare tutti gli elementi.\n");
    }

    public void showCrtrdgLevel() {
        System.out.println("Ink level:");

        for (Colore c : Colore.values()) {
            System.out.println(c.name() + " cartridge: " + cartridge[c.ordinal()]);
        }
    }
}