public class Main {
    public static void main(String[] args) {
        Personal p = new Personal();
        p.setAngesteller(new Manager());
        System.out.println(p.getGehaltszahlung());
        p.setAngesteller(new Ingenieur());
        System.out.println(p.getGehaltszahlung());
    }
}
