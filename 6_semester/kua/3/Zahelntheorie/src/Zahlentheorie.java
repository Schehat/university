import java.util.ArrayList;

public class Zahlentheorie {
    public ArrayList<Long> primZerlegung(long n) {
        try {
            if (n <= 1)
                throw new IllegalArgumentException();

            final long sqrtN = (long) Math.floor(Math.sqrt(n));
            ArrayList<Long> res = new ArrayList<>();

            for (long i = 2; i <= sqrtN; i++) {
                while (n % i == 0) {
                    n = n / i;
                    res.add(i);
                }
            }
            return res;
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Long> siebErastosthenes(long n) {
        try {
            if (n <= 1)
                throw new IllegalArgumentException();

            ArrayList<Long> res = new ArrayList<>();
            for (long i = 2; i <= n; i++) {
                if (primZerlegung(i).size() == 0) {
                    res.add(i);
                }
            }
            return res;
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    /**
     * x0 = 1, x1 = 0, x2 = x0 - q0x1
     * y0 = 0, y1 = 1, y2 = y0 - q0y1
     */
    public ArrayList<Long> ggT(long a, long b ) {
        try {
            if (a <= 1 ||b <= 1)
                throw new IllegalArgumentException();

            ArrayList<Long> ggTAndQs = euklid(a, b);

            ArrayList<Long> res = new ArrayList<>();
            res.add(ggTAndQs.get(ggTAndQs.size() - 1));
            res.add(diophantischeRecursive(ggTAndQs, 0, 1, 0));
            res.add(diophantischeRecursive(ggTAndQs, 0, 0, 1));

            return res;
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Long> diophant(long a, long b, long c) {
        try {
            if (a <= 1 ||b <= 1)
                throw new IllegalArgumentException();

            ArrayList<Long> ggTAndQs = euklid(a, b);
            // Condition not given ggT | c
            if (c % ggTAndQs.get(ggTAndQs.size() - 1) != 0)
                return new ArrayList<Long>();

            ArrayList<Long> res = new ArrayList<>();
            res.add(diophantischeRecursive(ggTAndQs, 0, 1, 0));
            res.add(diophantischeRecursive(ggTAndQs, 0, 0, 1));

            return res;
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    /**
     * res: [q1, r1, q2, r2, ..., qn, rn, ggT]. Note rn is always 0
     */
    public ArrayList<Long> euklid(long a, long b) {
        ArrayList<Long> res = new ArrayList<>();
        res.add(euklidCalc(res, a, b));
        return res;
    }

    public long euklidCalc(ArrayList<Long> res, long a, long b) {
        if (b == 0) {
            return a;
        }
        long q = a > b ? (long) (a / b) : (long) (b / a);
        long r = a > b ? (long) (a % b) : (long) (b % a);
        res.add(q);
        res.add(r);
        return euklidCalc(res, a > b ? b : a, r);
    }

    public long diophantischeRecursive(ArrayList<Long> ggTQsRs, int i, long a, long b) {
        long c = a - ggTQsRs.get(i)*b;
        // ggTQsRs[i+3] position where remainder = 0, don't need next iteration
        if (ggTQsRs.get(i+3) == 0)
            return c;
        i+=2;
        return diophantischeRecursive(ggTQsRs, i, b, c);
    }
}
