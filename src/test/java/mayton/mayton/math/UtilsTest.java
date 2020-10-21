package mayton.mayton.math;

import mayton.math.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {

    @Test
    public void testClp2() {
        assertEquals(0, Utils.clp2(0));
        assertEquals(1, Utils.clp2(1));
        assertEquals(2, Utils.clp2(2));
        assertEquals(4, Utils.clp2(3));
        assertEquals(4, Utils.clp2(4));
    }

    @Test
    public void testClp2Exceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Utils.clp2(-1);
        });
    }

    @Test
    public void testLog2Up() {
        assertEquals(0, Utils.log2up(0));
        assertEquals(0, Utils.log2up(1));
        assertEquals(1, Utils.log2up(2));
        assertEquals(2, Utils.log2up(3));
        assertEquals(2, Utils.log2up(4));
        assertEquals(3, Utils.log2up(5));
        assertEquals(3, Utils.log2up(6));
        assertEquals(3, Utils.log2up(7));
        assertEquals(3, Utils.log2up(8));
        assertEquals(4, Utils.log2up(9));
    }

    @Test
    public void ipTest() {
        assertEquals(0,           Utils.parseIpV4("0.0.0.0"));
        assertEquals(16843009,    Utils.parseIpV4("1.1.1.1"));
        assertEquals(2130706433,  Utils.parseIpV4("127.0.0.1"));
        assertEquals(4294967295L, Utils.parseIpV4("255.255.255.255"));
    }

}
