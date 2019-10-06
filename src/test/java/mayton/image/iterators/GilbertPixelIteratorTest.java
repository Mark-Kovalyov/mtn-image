package mayton.image.iterators;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;


public class GilbertPixelIteratorTest {

    static Logger logger =  LoggerFactory.getLogger(GilbertPixelIteratorTest.class);

    @BeforeClass
    public static void beforeClass() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/log4.properties");
    }

    @Test
    public void testNext4x4() {
        logger.info("::1");

        GilbertPixelIterator instance = new GilbertPixelIterator(1024);

        while (instance.next()) {
            // Do nothing
            int x = instance.getX();
            int y = instance.getY();
        }

        logger.info("::3");


        
    }

}