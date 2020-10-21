package mayton.image;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectTest {

    //(-2,-3)       (5,-3)
    // +------------+
    // |            |
    // |            |
    // +------------+
    // (-2,7)       (5,7)
    static Rect rect  = new Rect(-2, -3, 5, 7);
    static Rect rect2 = new Rect(-1, -2, 4, 6);
    static Rect rect3 = new Rect(10, 100, 200, 300);

    @Test
    public void testA() {
        assertEquals(-2, rect.x1);
        assertEquals(-3, rect.y1);
        assertEquals(5, rect.x2);
        assertEquals(7, rect.y2);
        assertEquals(7, rect.getWidth());
        assertEquals(10, rect.getHeight());
    }

    @Test
    public void testB() {
        assertTrue(rect.isPointInRect(-2,-3));
        assertFalse(rect.isPointInRect(5,-3));
        assertFalse(rect.isPointInRect(-2,7));
        assertFalse(rect.isPointInRect(5,7));
    }

    @Test
    public void testC() {
        assertTrue(rect.isIn(rect));
        assertTrue(rect2.isIn(rect2));
        assertFalse(rect3.isIn(rect));
    }


}
