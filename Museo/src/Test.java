public class Test {
    public static void main(String[] args) {
        Museo museo = new Museo();

        FileLoading f = new FileLoading(museo);
        f.load("museo.txt");

        museo.printSale();
        museo.stampaOggetti();
        museo.stampaOggOrdinati();
    }
}