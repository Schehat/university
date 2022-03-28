
public class DivAktie extends Aktie {
  private double gesamtDividende;

  /** Initialisiert eine neue Aktie. */
  public DivAktie(String isin) {
    super(isin);
    gesamtDividende= 0.0;
  }
  public void zahleDividende(double dividendeProAktie) {
    gesamtDividende += dividendeProAktie * getGesamtAnzahl();
  }
  /** Liefert den gesamten Gewinn oder Verlust, der mit
   * dieser Aktie verdient wurde, und zwar inklusive
   * Dividende, abhängig vom aktuellen Kurswert. */
  @Override public double getGewinn(double aktuellerKurs) {
    return super.getGewinn(aktuellerKurs) + gesamtDividende;
  }
}
