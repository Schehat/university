public class L332 {
    public static void main(String[] args) {
        String s = "irgendein Text zum extrahieren des 1. Wortes :)";
        System.out.print(s.substring(0, s.indexOf(" ")));
    }
}