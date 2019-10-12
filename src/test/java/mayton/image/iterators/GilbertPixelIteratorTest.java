package mayton.image.iterators;

import mayton.image.Point;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.concurrent.NotThreadSafe;

import static org.junit.Assert.*;

@NotThreadSafe
public class GilbertPixelIteratorTest {

    @BeforeClass
    public static void beforeClass() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/log4.properties");
    }

    @Test
    public void testNext1024x1024() {
        GilbertPixelIterator instance = new GilbertPixelIterator(1024);
        int cnt = 0;
        while (instance.next()) {
            cnt++;
        }
        assertEquals(1024 * 1024, cnt);
    }

    @Test
    public void testNext4x4() {
        GilbertPixelIterator instance = new GilbertPixelIterator(4);
        assertTrue(instance.next());
        assertEquals("(0,0)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(0,1)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(1,1)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(1,0)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(2,0)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(3,0)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(3,1)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(2,1)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(2,2)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(3,2)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(3,3)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(2,3)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(1,3)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(1,2)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(0,2)", new Point(instance.getX(),instance.getY()).toString());
        assertTrue(instance.next());
        assertEquals("(0,3)", new Point(instance.getX(),instance.getY()).toString());
        assertFalse(instance.next());
    }

}