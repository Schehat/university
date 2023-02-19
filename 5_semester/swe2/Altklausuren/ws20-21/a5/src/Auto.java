import java.util.ArrayList;

public class Auto {
    ArrayList<Zubehoer> zubehoer = new ArrayList<Zubehoer>();
    AutoType type;

    public void addZubehoer(Zubehoer zubehoer) {
        if (type.isAllowedToAddZubehoerType(zubehoer.getType())) {
            this.zubehoer.add(zubehoer);
            System.out.println("Zubehör erfolgreich hinzugefügt");
        } else {
            System.out.println("Aktion nicht erlaubt");
        }
    }

    public void setType(AutoType type) {
        this.type = type;
    }
}
