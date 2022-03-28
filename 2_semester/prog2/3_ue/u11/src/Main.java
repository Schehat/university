/**
 * Gruppe 03
 * @author Schehat
 * U11
 */
public class Main {

    public static void main(String[] args) {
        Ballspiel s= new Ballspiel();
        System.out.println("Ballspiel: ");
        System.out.println("  Mannschaften: " + s.getMannschaften());
        System.out.println("  Spieldauer  : " + s.getSpieldauer());
        System.out.println("  Bälle       : " + s.getBaelle());
        Fussball f= new Fussball();
        System.out.println("Fussball: ");
        System.out.println("  Mannschaften: " + f.getMannschaften());
        System.out.println("  Spieldauer  : " + f.getSpieldauer());
        System.out.println("  Bälle       : " + f.getBaelle());
        System.out.println("  Einwurf     : " + f.einwurfRegel());
        System.out.println("  Ecke        : " + f.eckRegel());
    }

}
