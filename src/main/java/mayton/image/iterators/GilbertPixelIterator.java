package mayton.image.iterators;

import mayton.math.Utils;

import java.util.*;


/**
 * <pre>
 *  0   1  14  15
 *  3   2  13  12
 *  4   7   8  11
 *  5   6   9  10
 * </pre>
 *
 * @author mayton
 */
public class GilbertPixelIterator implements IPixIterator {
    protected int x = 0;
    protected int y = 0;
    protected int x1 = 0;
    protected int y1 = 0;
    protected boolean stop;
    protected int size;
    protected int xv = 0;
    protected int yv = 1;

    protected Stack StackObj;

    protected int planeCount = 0;


    protected int[][] Plane = {
            {0, 0}, {1, 0}, {1, 1}, {0, 1},
            {0, 2}, {0, 3}, {1, 3}, {1, 2},
            {2, 2}, {2, 3}, {3, 3}, {3, 2},
            {3, 1}, {2, 1}, {2, 0}, {3, 0}
    };


    public GilbertPixelIterator(int size) {
        assert (size >= 4);
        x1 = 0;
        y1 = 0;
        // TODO: Re-check
        size = Utils.log2up(size); //Utility.extendToPowerOf2(size);
        reset();
    }

    public GilbertPixelIterator(int x, int y, int size) {
        assert (size >= 4);
        this.x1 = x;
        this.y1 = y;
        // TODO: Re-check
        size = Utils.log2up(size);//Utility.extendToPowerOf2(size);
        reset();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void reset() {
        stop = false;
    }

    public boolean next() {

        return false;
    }

}