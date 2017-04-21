/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.math;

import mayton.math.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 * @author mayton
 */
public class QuaternionTest {

    @Test
    public void testConstructor() {
       Quaternion q=new Quaternion(1.0d,2.0d,3.0d,4.0d);
       assertEquals(q.a,1.0d,0.0000000001d);
       assertEquals(q.b,2.0d,0.0000000001d);
       assertEquals(q.c,3.0d,0.0000000001d);
       assertEquals(q.d,4.0d,0.0000000001d);
    }

    @Test
    public void testSum() {
       Quaternion q1=new Quaternion(1.0d,2.0d,3.0d,4.0d);
       Quaternion q2=new Quaternion(5.0d,4.0d,3.0d,2.0d);
       Quaternion q3=Quaternion.sum(q1, q2);
       assertEquals(q3.a,6.0d,0.0000000001d);
       assertEquals(q3.b,6.0d,0.0000000001d);
       assertEquals(q3.c,6.0d,0.0000000001d);
       assertEquals(q3.d,6.0d,0.0000000001d);
    }

    @Ignore
    @Test
    public void testMul() {
       Quaternion q1=new Quaternion(1.0d,0.0d,0.0d,0.0d);
       Quaternion q2=new Quaternion(2.0d,2.0d,2.0d,2.0d);
       Quaternion q3=Quaternion.mul(q1, q2);
       assertEquals(q3.a,1.0d,0.0000000001d);
       assertEquals(q3.b,1.0d,0.0000000001d);
       assertEquals(q3.c,1.0d,0.0000000001d);
       assertEquals(q3.d,1.0d,0.0000000001d);
    }

    public void testModule()
    {
        Quaternion q1=new Quaternion(1.0d,2.0d,3.0d,4.0d);
        assertEquals(5.4772255d,
                     q1.getModule(),
                     0.0000001d);
    }

}