package mayton.image.iterators;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinearPixIteratorTest {

    IPixIterator ipx=null;

    public LinearPixIteratorTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        ipx=new LinearPixIterator(2,2);
    }

    @After
    public void tearDown() {
        ipx=null;
    }


    @Test
    public void testNext() {

        int x,y;
        //assertEquals(expResult, result);
        ipx.next();
            x=ipx.getX();
            y=ipx.getY();
            assertEquals(0, x);
            assertEquals(0, y);

        ipx.next();
            x=ipx.getX();
            y=ipx.getY();
            assertEquals(1, x);
            assertEquals(0, y);

        ipx.next();
            x=ipx.getX();
            y=ipx.getY();
            assertEquals(0, x);
            assertEquals(1, y);

        ipx.next();
            x=ipx.getX();
            y=ipx.getY();
            assertEquals(1, x);
            assertEquals(1, y);

    }

}