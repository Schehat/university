import java.util.ArrayList;

public class AutoType {
    ArrayList<ZubehoerType> zubehoerTypes = new ArrayList<ZubehoerType>();
    String name;

    public AutoType(String name, ZubehoerType zubehoerType) {
        this.name = name;
        zubehoerTypes.add(zubehoerType);
    }

    public boolean isAllowedToAddZubehoerType(ZubehoerType zubehoerType) {
        return zubehoerTypes.contains(zubehoerType);
    }

    public void addZubehoerType(ZubehoerType zubehoerType) {
        zubehoerTypes.add(zubehoerType);
    }
}
