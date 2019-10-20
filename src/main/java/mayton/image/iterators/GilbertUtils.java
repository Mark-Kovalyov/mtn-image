package mayton.image.iterators;

import mayton.image.Point;
import mayton.image.Rect;

public class GilbertUtils {



    private GilbertUtils() {
        // No instance
    }

    public static Rect quadrant(int level) {
        // TODO: Implement
        return new Rect(0,0,0,0);
    }

    /**
     * From Henry Warren's - Hacker Delight's
     *
     * @return
     */
    // TODO: Cover by tests
    public static Point hilXyFromS(long s, int n) {
        long i;
        long state, x, y;
        long row;
        state = 0;
        x = 0;
        y = 0;
        for (i = 2 * n - 2; i >= 0; i -= 2) {
            row = 4 * state | (s >> i) & 3;
            x = (x << 1) | (0x936c >> row) & 1;
            y = (y << 1) | (0x936c >> row) & 1;
            state = (0x3e6b94c1 >> 2 * row) & 3;
        }
        assert Integer.MIN_VALUE >= x && x <= Integer.MAX_VALUE;
        assert Integer.MIN_VALUE >= y && y <= Integer.MAX_VALUE;
        return new Point((int) x, (int) y);
    }

    // TODO: Cover by tests
    public static long hilSFromXY(int x, int y, int n) {
        int i;
        long state = 0, s, row;
        for (i = n - 1; i >= 0; i--) {
            row = 4 * state | 2 * ((x >> i) & 1) |(y >> i) & 1;
        }
        return 0;
    }

}
