package mayton.math;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author mayton
 */
public class PrimeGeneratorsTest {

    PrimeGeneratorSimple pgs;
    PrimeGeneratorFast pgf;

    public PrimeGeneratorsTest() {
        pgs = new PrimeGeneratorSimple();
        pgf = new PrimeGeneratorFast();
    }

    @Test
    @Disabled
    public void testSimple() {
        assertEquals(2, pgs.next());
        assertEquals(3, pgs.next());
        assertEquals(5, pgs.next());
        assertEquals(7, pgs.next());
        assertEquals(11, pgs.next());
        pgs.reset();
        assertEquals(2, pgs.next());
    }


    @Test
    @Disabled
    public void testFast() {
        /*
        assertEquals(2, pgf.getNext());
        assertEquals(3, pgf.getNext());
        assertEquals(5, pgf.getNext());
        assertEquals(7, pgf.getNext());
        assertEquals(11, pgf.getNext());
        pgf.reset();
        assertEquals(2, pgf.getNext());*/
    }

    @Test
    @Disabled
    public void complexTestWithComparison() {
        pgs.reset();
        pgf.reset();
        /*
        for (int k = 0; k < 1000; k++) {
            assertEquals(pgs.getNext(), pgf.getNext());
        }*/
    }

}
