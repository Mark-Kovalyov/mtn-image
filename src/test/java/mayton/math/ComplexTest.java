package mayton.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 *
 * @author mayton
 */
public class ComplexTest {

    @Test
    public void testConstructor() {

       Complex c=new Complex(1.0d,2.0d);
       assertEquals(c.a,1.0d,0.0000000001d);
       assertEquals(c.b,2.0d,0.0000000001d);
    }

    @Test
    public void testSum() {
        /*
       Quaternion q1=new Quaternion(1.0d,2.0d,3.0d,4.0d);
       Quaternion q2=new Quaternion(5.0d,4.0d,3.0d,2.0d);
       Quaternion q3=Quaternion.sum(q1, q2);
       assertEquals(q3.a,6.0d,0.0000000001d);
       assertEquals(q3.b,6.0d,0.0000000001d);
       assertEquals(q3.c,6.0d,0.0000000001d);
       assertEquals(q3.d,6.0d,0.0000000001d);*/
    }

    public void testModule()
    {
        
        Complex c=new Complex(3.0d,4.0d);
        assertEquals(5.0d,
                     c.getModule(),
                     0.0000001d);
    }
    
}