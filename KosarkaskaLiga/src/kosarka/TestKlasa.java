package kosarka;

import java.util.Random;

/**
 * Testira kreirane klase.
 * 
 * @author Vladimir Boskovic
 */
public class TestKlasa {
    
    public static void main(String[] args) {
        
        
        Trener t1 = new Trener("1234123412341", "Greg", "Popovic");
        Trener t2 = new Trener("1234123412342", "Moka", "Slavnic");
        
        Igrac ig1 = new Igrac("1234123412343", "Manu", "Djinobili", PozicijaUTimu.BEK);
        Igrac ig2 = new Igrac("1234123412344", "Toni", "Parker", PozicijaUTimu.PLEJMEJKER);
        Igrac ig3 = new Igrac("1234123412345", "LeBron", "Dzejms", PozicijaUTimu.KRILO);
        Igrac ig4 = new Igrac("1234123412347", "Pol", "Gasol", PozicijaUTimu.CENTAR);
        
        Tim tim1 = new Tim("San Antonio Spurs");
        tim1.setTrener(t1);
        tim1.dodajIgraca(ig1);
        tim1.dodajIgraca(ig2);
        
        Tim tim2 = new Tim("Cleveland Cavaliers");
        tim2.setTrener(t2);
        tim2.dodajIgraca(ig3);
        tim2.dodajIgraca(ig4);
        
        Utakmica u1 = new Utakmica(tim1, tim2, "115:105");
        
        System.out.println(u1.toString());
        
        
    }
    
}
