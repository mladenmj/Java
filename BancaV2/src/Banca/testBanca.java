package Banca;

import Banca.accountable.AbbonamentoSky;
import Banca.accountable.Stipendio;

public class testBanca {
    public static void main(String[] args) {
//        Banca Ubi = new Banca("UBI");
//
//        Ubi.aggiungiConto("JRK01", ContoType.CORRENTE);
//
//        Ubi.operazione("UBI0", 500);
//        Ubi.operazione("UBI0", 100);
//
//        Ubi.getSaldo("UBI0");
//
//        System.out.println(Ubi);

        Banca b = new Banca("UBI");

        b.aggiungiConto("AAA",ContoType.CORRENTE);
        b.aggiungiConto("BBB",ContoType.CORRENTE);
        b.aggiungiConto("CCC",ContoType.WEB);
        b.aggiungiConto("DDD",ContoType.DEPOSITO);

        b.operazione("UBI0", 1000);
        b.operazione("UBI1", 2000);
        b.operazione("UBI1", -30);

        b.operazione("UBI2", 200); //fails since not logged in
        b.logIn("UBI2", "changeme"); //fails! you cannot log in without immediately change the password (valid for first login only)
        b.changePass("UBI2", "changeme", "newpass");//you have to change your pass as first operation;
        b.changePass("UBI2", "newpass", "test");//fails! cannot change it more than once!
        b.logIn("UBI2", "newpass");//now succeeds
        b.operazione("UBI2", 2500);
        b.operazione("UBI2", -100);
        b.operazione("UBI3", 5000);
        b.operazione("UBI3", -1000); //fails since it's deposit
        System.out.println(b);

        Accountable s1 = new Stipendio(1300);
        Accountable abb1 = new AbbonamentoSky(true, true, true);
        Accountable abb2 = new AbbonamentoSky(true, false, false);
        b.addAccountable("UBI0", abb1);
        b.addAccountable("UBI2", abb2);
        b.addAccountable("UBI3", s1);
        b.fineMese();
        System.out.println("FINE MESE TRIGGERED");
        System.out.println(b);
    }
}