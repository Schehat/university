import java.util.*;

public class AktieLambdaMain  {
  public static void main(String[] args) {
    
//    Comparator<AnteilAnlage> cmp1= new Comparator<AnteilAnlage>() {
//      @Override public int compare(AnteilAnlage a1, AnteilAnlage a2) {
//        return a1.getIsin().compareTo(a2.getIsin());
//      }  
//    };
    
    Comparator<AnteilAnlage> cmp2= (a1,a2) -> a1.getIsin().compareTo(a2.getIsin());

    ArrayList<AnteilAnlage> portfolio= new ArrayList<AnteilAnlage>();
        
    Aktie allianz=new Aktie("DE0008404005");
    portfolio.add(allianz);
    allianz.kaufe(50, 35.06);
    allianz.kaufe(25, 38.52);
        
    Fonds investa= new Fonds("DE0008474008");
    portfolio.add(investa);
    investa.kaufe(17.34, 75.60);
    investa.kaufe(3.4, 79.10);

    DivAktie vw= new DivAktie("DE0007664005");
    portfolio.add(vw);
    vw.kaufe(7, 875.40);

    HashMap<String, Double> aktuelleKurse= new HashMap<String, Double>();
    aktuelleKurse.put(allianz.getIsin(), 39.41);
    aktuelleKurse.put(investa.getIsin(), 77.55);
    aktuelleKurse.put(vw.getIsin(), 869.90);
        
    portfolio.sort(cmp2);
    
    double gewinn= 0.0;
    for (AnteilAnlage a : portfolio) {
      System.out.println(a.getIsin());
      gewinn += a.getGewinn(aktuelleKurse.get(a.getIsin()));
    }
    System.out.format("Gesamtgewinn: %10.2f%n", gewinn);
  }
}
