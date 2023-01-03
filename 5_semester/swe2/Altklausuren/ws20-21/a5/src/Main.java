public class Main {
    public static void main(String[] args) {
        Kunde kunde = new Kunde();

        ZubehoerType navi14 = new ZubehoerType("Navi 14 Zoll Dispaly");
        AutoType sportwagen = new AutoType("sportwagen", navi14);

        ZubehoerType navi10 = new ZubehoerType("Navi 10 Zoll Dispaly");
        AutoType suv = new AutoType("suv", navi10);

        Zubehoer naviSportwagen = new Zubehoer("Navi", navi14);
        Zubehoer naviSUV = new Zubehoer("Navi", navi10);

        kunde.addAuto();

        kunde.getAuto().get(0).setType(sportwagen);
        kunde.getAuto().get(0).addZubehoer(naviSportwagen); // erfolgreich
        kunde.getAuto().get(0).addZubehoer(naviSUV);  // nicht

        kunde.addAuto();

        kunde.getAuto().get(1).setType(suv);
        kunde.getAuto().get(1).addZubehoer(naviSUV);  // erfolgreich
        kunde.getAuto().get(1).addZubehoer(naviSportwagen);  // nicht
    }
}