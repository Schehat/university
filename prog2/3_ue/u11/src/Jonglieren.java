/**
 * Gruppe 03
 * @author Schehat
 * U11
 */
public class Jonglieren extends Ballspiel {
    
    /**
     * Anzahl Mannschaften
     */
    @Override public int getMannschaften() {
        return 1;
    }
    
    /**
     * Anzahl Bälle
     */
    @Override public int getBaelle() {
        return 5;
    }
    
    /**
     * 
     * @return lernRegel
     */
    public String lernRegel() {
        return "Üben, üben, üben";
    }
}
