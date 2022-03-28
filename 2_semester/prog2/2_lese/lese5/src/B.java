
public class B extends A {
    private int x;
    
    public B (int x) {
        super(x);
        this.x = x + 1;
    }

    public int getX() {
        return x;
    }
}
