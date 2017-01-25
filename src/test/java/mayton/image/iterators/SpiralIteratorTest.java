/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.iterators;


import mayton.image.iterators.IPixIterator;
import mayton.image.iterators.SpiralIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mayton
 */
public class SpiralIteratorTest {

    public SpiralIteratorTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    int[][] testdata = new int[][]{
           {16, 15, 14, 13, 12},
           {17,  4,  3,  2, 11},
           {18,  5,  0,  1, 10},
           {19,  6,  7,  8,  9},
           {20, 21, 22, 23, 24},
    };
    
    @Test
    public void testTrivial() {
        IPixIterator ipx=new SpiralIterator(5);
        /*
        ipx.next();assertEquals("(2,2),0",ipx.toString());
        ipx.next();assertEquals("(3,2),1",ipx.toString());
        ipx.next();assertEquals("(3,1),2",ipx.toString());
        ipx.next();assertEquals("(2,1),3",ipx.toString());
        ipx.next();assertEquals("(1,1),4",ipx.toString());
        ipx.next();assertEquals("(1,2),5",ipx.toString());
        ipx.next();assertEquals("(1,3),6",ipx.toString());
        */
    }
    
    @Test
    public void test25x25() {
        
        IPixIterator ipx=new SpiralIterator(5);
        int xx=-1;
        int yy=-1;
        for (int i = 0; i < 25; i++) {
            global:
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (testdata[y][x] == i) {
                        boolean res=ipx.next();
                        //assertNotNull(res);
                        xx=x;
                        yy=y;
                        break global;
                    }
                }
            }        
            //assertEquals(String.format("%d,%d",xx,yy), ipx.toString());
        }
    }

    

}