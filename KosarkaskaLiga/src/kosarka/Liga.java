package kosarka;

/**
 * Predstavlja kosarksasku ligu. Cine je timovi i utakmice.
 * 
 * @author Vladimir Boskovic
 */
public class Liga {
    
    private String imeLige;
    private Tim[] timovi = new Tim[16];
    private Utakmica[] utakmice = new Utakmica[240];

    public Liga(String imeLige) {
        this.imeLige = imeLige;
    }
    
    // implementirati metode za dodavanje timova i utakmica
}
