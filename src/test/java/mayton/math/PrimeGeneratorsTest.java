package mayton.math;

import mayton.math.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;

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
    public void testSimple() {
        /*assertEquals(2L, pgs.next());
        assertEquals(3, pgs.getNext());
        assertEquals(5, pgs.getNext());
        assertEquals(7, pgs.getNext());
        assertEquals(11, pgs.getNext());
        pgs.reset();
        assertEquals(2, pgs.getNext());*/
    }

    @Ignore
    @Test
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

    @Ignore
    @Test
    public void complexTestWithComparison() {
        pgs.reset();
        pgf.reset();
        /*
        for (int k = 0; k < 1000; k++) {
            assertEquals(pgs.getNext(), pgf.getNext());
        }*/
    }

}
