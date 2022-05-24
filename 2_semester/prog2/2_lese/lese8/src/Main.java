public class Main {

    public static void main(String[] args) {
        Shape[] s = {new A(3, 2), new B(5), new C(10, 5)};
        N[] n = {new A(3, 2), new C(10, 5)};
        int sumM = 0;
        int sumN = 0;
        for (Shape i : s) {
            sumM += i.getM();
        }
        for (N i : n) {
            sumN += i.getN();
        }
        System.out.println(sumM + " " + sumN);
    }

}
