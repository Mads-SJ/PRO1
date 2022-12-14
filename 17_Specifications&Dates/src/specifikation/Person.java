package specifikation;

/**
 * Modellerer en person.
 */
public class Person {
    
    private String navn;
    private int alder;
    
    /**
     * Initialiserer en ny persons navn og alder.
     * @param navn personens navn
     * @param alder personens alder
     * Pre: alder &gt;= 0
     */
    public Person(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
        
    }
    
    /**
     * Returnerer personens alder.
     * @return personens alder
     */
    public int getAlder() {
        return alder;
    }
    
    /**
     * Registrerer personens alder.
     * @param alder
     * Pre: alder &gt;= 0
     */
    public void setAlder(int alder) {
        this.alder = alder;
    }
    
    /**
     * Returnerer personens navn.
     * @return navn på personen
     */
    public String getNavn() {
        return navn;
    }
    
    /**
     * Registrerer personens navn.
     *
     * @param navn er personens nye navn
     */
    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    /**
     * Afgoer om personen er aeldre end en given alder.
     * @param alder den alder der skal sammenlignes med
     * @return om personen er aeldre end alder
     */
    public boolean aeldreEnd(int alder) {
        return this.alder > alder;
    }
    
}
