package mayton.image.iterators;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinearPixIteratorTest {

    @Test
    public void testRect() {

        IPixIterator ipx = new LinearPixIterator(2, 2);

        int x, y;
        ipx.next();
        x = ipx.getX();
        y = ipx.getY();
        assertEquals(0, x);
        assertEquals(0, y);

        ipx.next();
        x = ipx.getX();
        y = ipx.getY();
        assertEquals(1, x);
        assertEquals(0, y);

        ipx.next();
        x = ipx.getX();
        y = ipx.getY();
        assertEquals(0, x);
        assertEquals(1, y);

        ipx.next();
        x = ipx.getX();
        y = ipx.getY();
        assertEquals(1, x);
        assertEquals(1, y);

    }

    @Test
    public void testSquare() {
        IPixIterator ipx = new LinearPixIterator(2);
        assertTrue(ipx.next());
        assertTrue(ipx.next());
        assertTrue(ipx.next());
        assertTrue(ipx.next());
        assertFalse(ipx.next());
    }

    @Test
    public void testRectWithTranslate() {
        IPixIterator ipx = new LinearPixIterator(3,5,7,9);
        while(ipx.next()) {
            System.out.printf("(%d,%d)\n", ipx.getX(), ipx.getY());
        }
    }



}