public class Aktie extends AnteilAnlage {
  private int gesamtAnzahl;
    
  public Aktie(String isin) {
    super(isin);
    gesamtAnzahl= 0;
  }
  @Override public double getMarktwert(double aktuellerKurs) {
    return gesamtAnzahl * aktuellerKurs;
  }
  public void kaufe(int anzahl, double kaufKurs) {
    gesamtAnzahl += anzahl;
    addiereKosten(anzahl * kaufKurs);
  }
  public int getGesamtAnzahl() {
    return gesamtAnzahl;
  }
@Override
public int compare(AnteilAnlage o1, AnteilAnlage o2) {
    // TODO Auto-generated method stub
    return 0;
}
}

