package kosarka;

/**
 * Predstavlja kosarkaski tim.
 *
 * @author Vladimir Boskovic
 */
public class Tim {

    private String imeTima;

    // predstavlja trenera tima
    private Trener trener;

    private Igrac[] igraci = new Igrac[12];
    
    private int brojIgraca = 0;

    public Tim(String imeTima) {
        this.imeTima = imeTima;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public String getImeTima() {
        return imeTima;
    }
    
    /**
     * Dodaje novog igraca u tim, ukoliko tim nije popunjen.
     *
     * @param noviIgrac
     * @return
     */
    public boolean dodajIgraca(Igrac noviIgrac) {
        if (daLiJePopunjenTim()) {
            System.out.println("Tim "+imeTima+" je popunjen.");
            return false;
        }
        // dodajemo novog igraca, pa inkrementiramo brojIgraca
        igraci[brojIgraca++] = noviIgrac;
        System.out.println("Novi igrac "+noviIgrac.getIme()+" je dodat u "+imeTima);
        return true;
    }

    public boolean daLiJePopunjenTim() {
        return (brojIgraca == igraci.length);
//        if (brojIgraca == igraci.length) {
//            return true;
//        } else {
//            return false;
//        }
    }

}
