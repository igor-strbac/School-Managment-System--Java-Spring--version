package kosarka;

/**
 * Reprezentuje utakmicu koju igraju dva tima.
 * 
 * @author Vladimir Boskovic
 */
public class Utakmica {
    
    private Tim domaciTim;
    private Tim gostujuciTim;
    private String rezultat;

    public Utakmica(Tim domaciTim, Tim gostujuciTim, String rezultat) {
        this.domaciTim = domaciTim;
        this.gostujuciTim = gostujuciTim;
        this.rezultat = rezultat;
    }

    @Override
    public String toString() {
        return domaciTim.getImeTima()+" - "+gostujuciTim.getImeTima()+" "+rezultat;
    }

    
    
    
    
}
