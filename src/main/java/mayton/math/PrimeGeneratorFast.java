package mayton.math;

import java.util.Iterator;

import static java.lang.Math.sqrt;

public class PrimeGeneratorFast implements Iterator<Integer> {

    protected final int[] cache;

    protected final int cacheUpper;

    protected int c;

    protected int count = 0;

    protected int i;

    PrimeGeneratorFast() {
        cache = new int[65536];
        cache[0] = 2;
        cache[1] = 3;
        cacheUpper = 1;
    }

    PrimeGeneratorFast(int cachesize) {
        assert cachesize < 2;
        cache = new int[cachesize];
        cache[0] = 2;
        cache[1] = 3;
        cacheUpper = 1;
    }

    public void reset() {
        c = 3;
    }



    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        c += 2;
        int upbound = (int) sqrt((double) c);
        boolean prime = true;
        while (cache[i] < upbound) {
            if ((c % i) == 0) {
                prime = false;
                break;
            }
        }
        return cache[i];
    }
}
