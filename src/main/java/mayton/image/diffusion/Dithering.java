package mayton.image.diffusion;

import mayton.image.Raster;
import mayton.math.Matrix;
import mayton.math.INumericMatrix;
import mayton.math.MatrixNumeric;
import mayton.math.MatrixDither4x4;

import java.awt.Color;


/**
 * | 0  2 |
 * D2 = |      |
 * | 3  1 |
 * <p>
 * <p>
 * | 4D(n/2)           4D(n/2)+2U(n/2) |
 * Dn = |                                   |
 * | 4D(n/2)+3U(n/2)   4D(n/2)+U(n/2)  |
 * <p>
 * <p>
 * <p>
 * | 0   8   2   10 |
 * D4 = | 12  4   14  6  |
 * | 3   11  1   9  |
 * | 15  7   13  5  |
 * <p>
 * <p>
 * foreach( pixel in 8bit_picture )
 * {
 * // I(pixel) -
 * // Dn(i,j) -
 * // X Mod Y -
 * // i, pixel.Y -
 * i = pixel.Y Mod n;
 * // j, pixel.X -
 * j = pixel.X Mod n;
 * if( I(pixel) > Dn(i,j) )
 * I(pixel) =
 * else
 * I(pixel) =
 * }
 */

public class Dithering implements IDiffusionAlgorithm {


    public Raster processRaster(Raster r) {
        Matrix m = MatrixDither4x4.getInstance();

        MatrixNumeric nm = new MatrixNumeric(r.X, r.Y);

        byte[] indexes = new byte[r.X * r.Y];
        int n = 0;
        for (int x = 0; x < r.X; x++) {
            for (int y = 0; y < r.Y; y++) {
                double light = r.getYPixelDouble(x, y);
                double c = (m.get(x & 0x03, y & 0x03) / 15.0);
                //System.out.printf("%f, %f\n",light,c);
                if (light > c) indexes[n] = 1;
                else indexes[n] = 0;
                n++;
            }
            //System.out.printf("\n");
        }

        return null;
    }
}
