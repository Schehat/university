public class Fonds extends AnteilAnlage {
  private double gesamtAnzahl;
    
  public Fonds(String isin) {
    super(isin);
    gesamtAnzahl= 0.0;
  }
  @Override public double getMarktwert(double aktuellerKurs) {
    return gesamtAnzahl * aktuellerKurs;
  }
  public void kaufe(double anzahl, double kaufKurs) {
    gesamtAnzahl += anzahl;
    addiereKosten(anzahl * kaufKurs);
  }
  public double getGesamtAnzahl() {
    return gesamtAnzahl;
  }
@Override
public int compare(AnteilAnlage o1, AnteilAnlage o2) {
    // TODO Auto-generated method stub
    return 0;
}
}
