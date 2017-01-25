package mayton.math;

public class PrimeGeneratorSimple implements INumGenerator {

    protected int c = 1;
    protected int count = 0;

    public int getNext() {
        if (count == 0) {
            count++;
            return 2;
        } else {
            while (true) {
                c += 2;
                int ub = (int) Math.sqrt((double) c);
                boolean isprime = true;
                for (int i = 2; i <= ub; i++) {
                    if ((c % i) == 0) {
                        isprime = false;
                        break;
                    }
                }
                if (isprime) break;                
            }
            count++;
            return c;
        }
    }

    public boolean hasNext() {
        return true;
    }

    public void reset() {
        c = 1;
        count = 0;
    }
}
