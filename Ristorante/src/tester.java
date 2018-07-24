import Menu.Menu;
import Ristoranti.Enoteca;
import Ristoranti.Ristorante;

public class tester {
    public static void main(String[] args) {
        Menu m = new Menu();

        menuLoader loader = new menuLoader(m);
        loader.load("menu1.txt");

        Ristorante r = new Ristorante("Taverna da Mladen", m);
        Enoteca e = new Enoteca("EnoGastro", m);
        Ristorante r2 = new Ristorante("Taverna da Rape", m);

        System.out.println(r);
        System.out.println(r2);
        System.out.println(e);

        r.ordinaMenuPerPrezzo();

        System.out.println("Menu Ordinato:\n" + r);
    }
}