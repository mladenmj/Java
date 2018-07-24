package tester;

import Loader.FileLoader;
import partite.Partita;
import partite.PartitaCalcio;
import squadre.Squadra;

import java.io.File;

public class test {
    public static void main(String[] args) {
        FileLoader loadCalcio = new FileLoader();
        FileLoader loadVolley = new FileLoader();

        Squadra juve = new Squadra("Juventus");
        Squadra roma = new Squadra("Roma");

        Partita game1 = new PartitaCalcio(juve, roma);

        loadCalcio.getEvents(new File("calcio.txt"));
        loadVolley.getEvents(new File("volley.txt"));


    }
}