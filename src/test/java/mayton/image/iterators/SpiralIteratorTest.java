/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.iterators;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author mayton
 */
class SpiralIteratorTest {

    int[][] testdata = new int[][]{
           {16, 15, 14, 13, 12},
           {17,  4,  3,  2, 11},
           {18,  5,  0,  1, 10},
           {19,  6,  7,  8,  9},
           {20, 21, 22, 23, 24},
    };


    @Disabled("Not implemented yet")
    @Test
    void testTrivial() {
        IPixIterator ipx=new SpiralIterator(5);
        ipx.next();assertEquals("(2,2),0",ipx.toString());
        ipx.next();assertEquals("(3,2),1",ipx.toString());
        ipx.next();assertEquals("(3,1),2",ipx.toString());
        ipx.next();assertEquals("(2,1),3",ipx.toString());
        ipx.next();assertEquals("(1,1),4",ipx.toString());
        ipx.next();assertEquals("(1,2),5",ipx.toString());
        ipx.next();assertEquals("(1,3),6",ipx.toString());
    }

    @Disabled("Not implemented yet")
    @Test
    void test25x25() {
        IPixIterator ipx=new SpiralIterator(5);
        int xx=-1;
        int yy=-1;
        for (int i = 0; i < 25; i++) {
            global:
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (testdata[y][x] == i) {
                        boolean res=ipx.next();
                        xx=x;
                        yy=y;
                        break global;
                    }
                }
            }

        }
    }

    

}