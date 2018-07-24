import Distribuzione.*;

public class Test {
    public static void main(String[] args) {
        FileLoader fileLoader = new FileLoader();

        fileLoader.load();

        Distributore d = fileLoader.creaDistrib();
        d.refillDistributore();

        d.testSetNotAvailable(0);
        d.testSetNotAvailable(3);
        d.showAvailableProducts(true);
        d.showAvailableProducts(false);

        d.acquistaProdotto();
        d.showMoneyInside();
        d.acquistaProdotto();
        d.showMoneyInside();
        d.resetMonete();
        d.acquistaProdotto();
        d.showMoneyInside();

        //TODO: insert GUI here...
    }
}