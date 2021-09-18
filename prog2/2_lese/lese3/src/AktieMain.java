import java.util.Scanner;
    public class AktieMain {
        public static void main(String[] args) {
            Scanner console= new Scanner(System.in);
            
            // Erste Aktie
            System.out.print("ISIN der ersten Aktie: ");
            Aktie aktie1= new Aktie(console.next());
            double gewinn1= taetigeKaeufe(aktie1, console);

            // Zweite Aktie
            System.out.print("ISIN der zweiten Aktie: ");
            Aktie aktie2= new Aktie(console.next());
            double gewinn2= taetigeKaeufe(aktie2, console);

            // Ermittle die besser gelaufene Aktie
            if (gewinn1 > gewinn2) {
                System.out.println(aktie1.getIsin() + " war rentabler als " + aktie2.getIsin() + ".");
            } else if (gewinn2 > gewinn1) {
                System.out.println(aktie2.getIsin() + " war rentabler als " + aktie1.getIsin() + ".");
            } else { // gewinn1 == gewinn2
                System.out.println(aktie1.getIsin() + " und " + aktie2.getIsin() + " waren gleich rentabel.");
            }
        }

            /** fragt K�ufe ab und liefert den Gewinn */
            public static double taetigeKaeufe(Aktie aktie, Scanner console) {
                System.out.print("Wie viele K�ufe haben Sie get�tigt? ");
                int anzahlKaeufe= console.nextInt();
            
                // frage nach jedem Kauf:
                for (int i=1; i<=anzahlKaeufe; i++) {
                    System.out.print(i + ": Wieviele Aktien zu welchem Kaufkurs? ");
                    int anzahl= console.nextInt();
                    double kaufKurs= console.nextDouble();
                
                    // Beauftrage das Aktien-Objekt, den Kauf zu speichern.
                    aktie.kaufe(anzahl, kaufKurs);
                 }
                
                // Berechne den Gewinn
                System.out.print("Zu welchem Kurs notiert die Aktie heute? ");
                double aktuellerKurs= console.nextDouble();
                double gewinn= aktie.getGewinn(aktuellerKurs);
                System.out.println("Nettogewinn/-verlust: " + gewinn);
                System.out.println();
                return gewinn;
            }
}