public class Aktie {
    private int gesamtAnzahl;
    private double gesamtKosten;
    private String isin;
    
    /** Initialisiert eine neue Aktie.
     * Vorbdg.: isin != null */
     public Aktie(String isin) {
         if (isin == null) {
             throw new NullPointerException("isin darf nicht null sein");
         }
         this.isin= isin;
         gesamtAnzahl= 0;
         gesamtKosten= 0.0;
     }
    
     
     public String getIsin() {
         return isin;
     }

    
    /** Vorbdg.: anzahl und kaufKurs >= 0 */
    public void kaufe(int anzahl, double kaufKurs) {
        if (kaufKurs < 0) {
            throw new IllegalArgumentException("kaufKurs muss >= 0 sein");
        }
        if (anzahl < 0) {
            throw new IllegalArgumentException("anzahl muss >= 0 sein");
        }
        gesamtAnzahl += anzahl;
        gesamtKosten += anzahl * kaufKurs;
    }

    /** Liefert den gesamten Gewinn oder Verlust, der mit
     * dieser Aktie verdient wurde, abh�ngig vom aktuellen
     * Kurswert.
     * Vorbdg.: aktuellerKurs >= 0.0 */
     public double getGewinn(double aktuellerKurs) {
         if (aktuellerKurs < 0) {
             throw new IllegalArgumentException("aktuellerKurs muss " + ">= 0 sein");
         }
         double marktWert= gesamtAnzahl * aktuellerKurs;
         return marktWert - gesamtKosten;
     }
}
