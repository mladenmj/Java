package Distributore;

import Bevande.*;
import Errori.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Distributore {

    private HashMap<String,Bevanda> list;
    private int cup, cupMax, spoon, spoonmax;
    private double water, watermax;
    private double sugar, sugarMax;
    private double milk, milkMax;
    private Coins coins;
    private ArrayList<String[]> listFromFile;
    private String[] statistics;

    public Distributore(ArrayList listFromFile) {

        this.list = new HashMap<>();
        this.listFromFile = listFromFile;
        this.coins = new Coins();
        setVendingMachine();
    }

    /**TODO AGGIUNGERE LE INTERFACCE PER I CAMPI FINAL
     * Carica i valori massimi nella macchinetta
     */

    // Da rivedere, troppe azioni ripetitive

    private void setVendingMachine() {

        this.cupMax = parseInt(listFromFile.get(0)[0]);
        this.cup = cupMax;
        this.spoonmax = parseInt(listFromFile.get(0)[1]);
        this.spoon = spoonmax;
        this.watermax = parseDouble(listFromFile.get(0)[2]);
        this.water = watermax;
        this.sugarMax = parseDouble(listFromFile.get(0)[3]);
        this.sugar = sugarMax;
        this.milkMax = parseDouble(listFromFile.get(0)[4]);
        this.milk = milkMax;
        //todo add server quando ci sarà

        //mi devo ricordare che dalla seconda riga in poi sono le bevande
        createList();
    }

    /**
     * Creo il menu nella macchinetta
     */

    private void createList() {

        for (int i = 1; i < listFromFile.size(); i++){
            Tipo tipo = Tipo.valueOf(listFromFile.get(i)[1]);
            Bevanda bevanda = null;
            switch (tipo.ordinal()) {
                case 0:
                    bevanda = new Macinato(listFromFile.get(i));
                    list.put(listFromFile.get(i)[0],bevanda);
                    break;
                case 1:
                    bevanda = new Capsula(listFromFile.get(i));
                    list.put(listFromFile.get(i)[0],bevanda);
                    break;
                case 2:
                    bevanda = new Solubile(listFromFile.get(i));
                    list.put(listFromFile.get(i)[0],bevanda);
                    break;
                default:
                    new InvalidType();
                    continue;
            }
        }

    }

    /**
     * Funzione per recepire i comandi testuali ed analizzarli.
     */

    public void textualInput (){
        showList();
        System.out.println("Inserire il codice della bevanda e la quantità di zucchero richiesta (da 0 a 5)\nseparate da uno spazio.");
        String input = null;
        try {
            input = keyboard();
        } catch (NoDigit noDigit) {
            noDigit.printStackTrace();
        }
        String[] splitted = input.split("\\s+");
        //mi chiedo se la bevanda è disponibile
        if (list.get(splitted[0]).isAvailable()) {
            System.out.println("Inserire il numero di monete inserite riferite al rispettivo taglio separandole con uno spazio.\ntipo: 0.05c 0.10c 0.20c 0.50c 1 2");
            try {
                input = keyboard();
            } catch (NoDigit noDigit) {
                noDigit.printStackTrace();
            }
            coins.addCredit(input);
            //vera e propria funzione da usare nella interfaccia
            try {
                selectBeverage(splitted[0], parseInt(splitted[1]));
            } catch (UnsufficientCredit unsufficientCredit) {
                unsufficientCredit.printStackTrace();
            }
        }
        else {
            new BeverageNotAvailable();
        }

    }

    /**
     * Funzione per recepire input da tastiera e restituirli sotto forma di stringa.
     */

    public String keyboard() throws NoDigit{
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(keyboard);
        try {
            String letta = bufferedReader.readLine();
            //TODO C'è DA CAPIRE PERCHè SE LE CHIUDO ESPLODE IL MONDO
            // keyboard.close();
            //bufferedReader.close();
            return letta;
        } catch (IOException e) {
            throw new NoDigit();
        }
    }

    /**
     * Funzione per selezionare una bevanda. Essa controlla che il credito sia sufficiente
     * @param beverage: è l'id della bevanda selezionata
     * @param sugar: è la qunatità di zucchero da 0 a 5
     */

    private void selectBeverage(String beverage,int sugar) throws UnsufficientCredit{
        if (coins.getCredit()>=list.get(beverage).getPrice()){ //se il credito è uguale o più singifica che posso potenzialmente acquistare la bevanda
                subtractIngredients(beverage);
                subtractSugar(sugar);
                coins.updateBalance(list.get(beverage).getPrice());
                if (coins.getCredit()!= 0) {
                    coins.giveChange();
                }
            }
        else{
            throw new UnsufficientCredit();
        }
            // If beverage doesn't exist? Or if not digited correctly?
    }

    /**
     * Funzione per sottrarre quantità necessarie per preparare la bevanda
     * @param bevanda bevanda da cui sottrarre
     */
    private void subtractIngredients(String bevanda) {
        milk -= list.get(bevanda).getMilk();
        water -= list.get(bevanda).getWater();
        cup--;

    }

    /**
     * Funzione che sottrae lo zucchero usato
     * @param qty, valore tra 0 e 5
     */

    private void subtractSugar(int qty){
        if (qty != 0){
            sugar -= (double) qty * 0.022/5;
            spoon--;
        }
    }

    /**
     * Funzione per erogare il resto.
     */
    private void giveChange() {
        coins.giveChange();
        //TODO sistemare il resto
        System.out.println("Erogazione il resto di: " + coins);;
    }

    /**
     * Funziona che mostra la lista delle bevande contenute nel distributore.
     */
    private void showList() {
        for (int i = 1; i < list.size() + 1; i++){
            System.out.println(list.get("0" + i));
        }
    }
}

