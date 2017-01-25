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

public class MatrixQuantizationJPEGLuminance extends MatrixNumeric{

    protected static int m[][]={
        {16,  11,  12,  14,  12,  10,  16,  14},
        {13,  14,  18,  17,  16,  19,  24,  40},
        {26,  24,  22,  22,  24,  49,  35,  37},
        {29,  40,  58,  51,  61,  60,  57,  51},
        {56,  55,  64,  72,  92,  78,  64,  68},
        {87,  69,  55,  56,  80, 109,  81,  87},
        {95,  98, 103, 104, 103,  62,  77, 113},
        {121,112, 100, 120,  92, 101, 103,  99}            
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
