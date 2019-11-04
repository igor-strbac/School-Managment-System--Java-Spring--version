package kosarka;

/**
 * Reprezentuje kosarkasa.
 * 
 * @author Vladimir Boskovic
 */
public class Igrac {
    
    private String jmbg;
    private String ime;
    private String prezime;
    private PozicijaUTimu pozicija;

    public Igrac(String jmbg, String ime, String prezime, PozicijaUTimu pozicija) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public PozicijaUTimu getPozicija() {
        return pozicija;
    }

    public void setPozicija(PozicijaUTimu pozicija) {
        this.pozicija = pozicija;
    }

    
    
    
    
    
}
