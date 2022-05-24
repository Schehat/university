
public class C implements Shape, N {
    private int m, n;

    public C (int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override public int getM() {
        return m;
    }
    
    @Override public int getN() {
        return n;
    }
}
