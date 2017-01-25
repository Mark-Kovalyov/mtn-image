package mayton.image.iterators;

import mayton.image.iterators.GilbertPixelIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GilbertPixelIteratorTest {

    @Test
    public void testNext4x4() {
        System.out.println("next");
        GilbertPixelIterator instance = new GilbertPixelIterator(4);
        boolean expResult = false;
        boolean result = instance.next();
            assertEquals(0, instance.getX());
            assertEquals(0, instance.getY());
        instance.next();       
        
    }

}