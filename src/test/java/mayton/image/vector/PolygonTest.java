/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayton.image.vector;

import java.util.Iterator;
import mayton.image.Fpoint;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author mayton
 */
public class PolygonTest {
    
    @Test
    public void testTriangle(){
        
        Fpolygon polygon = Fpolygon.createTriangle(0.0, 0.0, 3.0, 0.0, 0.0, 4.0);
        Iterator<Fpoint> points = polygon.getPoints();
        assertTrue(points.hasNext());
                
        Fpoint p1 = points.next();
        assertEquals(0.0, p1.x, 0.0001);
        assertEquals(0.0, p1.y, 0.0001);
        
        Fpoint p2 = points.next();
        assertEquals(3.0, p2.x, 0.0001);
        assertEquals(0.0, p2.y, 0.0001);
        
        Fpoint p3 = points.next();
        assertEquals(0.0, p3.x, 0.0001);
        assertEquals(4.0, p3.y, 0.0001);
        
        
        //assertEquals(6.0, polygon.getSquare(), 0.0001);
    }
    
}
