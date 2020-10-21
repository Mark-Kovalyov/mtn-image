/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.math;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * @author mayton
 */
public class NumericTest {


    @Test
    public void testFact_int()
    {
        assertEquals((long)1, Numeric.fact((int)0));
        assertEquals((long)1, Numeric.fact((int)1));
        assertEquals((long)2, Numeric.fact((int)2));
        assertEquals((long)6, Numeric.fact((int)3));
        assertEquals((long)24, Numeric.fact((int)4));
        assertEquals((long)120, Numeric.fact((int)5));
    }

    @Test
    public void testFact_long() {
        assertEquals((long)1, Numeric.fact((long)0));
        assertEquals((long)1, Numeric.fact((long)1));
        assertEquals((long)2, Numeric.fact((long)2));
        assertEquals((long)6, Numeric.fact((long)3));
        assertEquals((long)24, Numeric.fact((long)4));
        assertEquals((long)120, Numeric.fact((long)5));
    }

    @Test
    public void testsubFact()
    {
        assertEquals((long)1, Numeric.subFact(1, 1));
        assertEquals((long)2, Numeric.subFact(1, 2));
        assertEquals((long)12, Numeric.subFact(3, 4));
        assertEquals((long)60, Numeric.subFact(3, 5));
    }

    @Test
    public void testFact_BigInteger() {

        assertEquals("1", Numeric.fact(BigInteger.ZERO).toString());
        assertEquals("1", Numeric.fact(BigInteger.ONE).toString());
        assertEquals(BigInteger.valueOf(6),  Numeric.fact(BigInteger.valueOf(3)));
        assertEquals(BigInteger.valueOf(24), Numeric.fact(BigInteger.valueOf(4)));
        assertEquals("120", Numeric.fact(BigInteger.valueOf(5)).toString());
        assertEquals(
                "815915283247897734345611269596115894272000000000",
                Numeric.fact(BigInteger.valueOf(40)).toString()
        );
    }

    @Test
    public void testSubFact()
    {
        assertEquals(1, Numeric.subFact(1, 1));
        assertEquals(360, Numeric.subFact(3, 6));
        assertEquals(210, Numeric.subFact(5, 7));
        assertEquals(60, Numeric.subFact(3, 5));
    }


    @Test
    public void testPermutation() {
        assertEquals(6, Numeric.permutation(4, 2));

        //assertEquals(8568,Numeric.permutation(18, 5));
        //assertEquals(376992,Numeric.permutation(36L, 5L));
        //assertEquals(8145060,Numeric.permutation(45L, 6L));
    }


    

}