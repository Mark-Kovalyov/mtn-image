package mayton.image.iterators;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinearPixIteratorTest {

    @Test
    public void testNext() {

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

}