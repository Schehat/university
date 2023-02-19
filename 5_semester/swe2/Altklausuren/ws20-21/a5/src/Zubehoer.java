public class Zubehoer {
    ZubehoerType zubehoerType;
    String name;

    public Zubehoer(String name, ZubehoerType zubehoerType) {
        this.name = name;
        this.zubehoerType = zubehoerType;
    }

    public ZubehoerType getType() {
        return zubehoerType;
    }
}
