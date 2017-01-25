package mayton.image.iterators;

/**
 *  The JPEG proposal defines the term Minimum Coded Unit (MCU) to be the smallest
 *  group of interleaved data units. For the example
 *  shown, MCU1 consists of data units taken first from the
 *  topleftmost
 *  region of C1, followed by data units from
 *  the same region of C2, and likewise for C3 and C4.
 *  MCU2 continues the pattern as shown.
 */
public class MCU1PixIterator implements IPixIterator{

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }

    public boolean next() {
        return false;
    }

    public void reset() {

    }
}
