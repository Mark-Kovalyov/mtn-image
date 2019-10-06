package mayton.image.iterators;

import mayton.math.Utils;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;


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

    public GilbertPixelIterator(int size) {
        checkArgument(size >= 4);
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public boolean next() {
        return false;
    }

    @Override
    public void reset() {

    }
}