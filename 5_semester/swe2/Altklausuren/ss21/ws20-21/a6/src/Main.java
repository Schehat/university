public class Main {
    public static void main(String[] args) {
        Datenstrom datenstrom = new Datenstrom();
        datenstrom.open();
        datenstrom.open();
        datenstrom.close();
        datenstrom.close();
        datenstrom.open();
    }
}
