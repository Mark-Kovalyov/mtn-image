package mayton.math;

/**
 *   This is the sample quantization table given in the JPEG spec section K.1,
 *   but expressed in zigzag order (as are all of our quant. tables).
 *   The spec says that the values given produce "good" quality, and
 *   when divided by 2, "very good" quality.  (These two settings are
 *   selected by quality=50 and quality=75 respectively.)
 * 
 *   2006.11.05             MKovalev
 *
 */


public class MatrixQuantizationJPEGChrominance extends MatrixNumeric
{
    protected static int m[][]={
        {17,  18,  18,  24,  21,  24,  47,  26},
        {26,  47,  99,  66,  56,  66,  99,  99},
        {99,  99,  99,  99,  99,  99,  99,  99},
        {99,  99,  99,  99,  99,  99,  99,  99},
        {99,  99,  99,  99,  99,  99,  99,  99},
        {99,  99,  99,  99,  99,  99,  99,  99},
        {99,  99,  99,  99,  99,  99,  99,  99},
        {99,  99,  99,  99,  99,  99,  99,  99}
    };

    public int get(int X, int Y) throws IndexOutOfBoundsException {
        return m[X][Y];
    }

    public int getX() {
        return 8;
    }

    public int getY() {
        return 8;
    }
}
