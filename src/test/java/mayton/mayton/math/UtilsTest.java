package mayton.mayton.math;

import mayton.math.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void testClp2() {
        assertEquals(0, Utils.clp2(0));
        assertEquals(1, Utils.clp2(1));
        assertEquals(2, Utils.clp2(2));
        assertEquals(4, Utils.clp2(3));
        assertEquals(4, Utils.clp2(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClp2Exceptions() {
        Utils.clp2(-1);
    }

}
