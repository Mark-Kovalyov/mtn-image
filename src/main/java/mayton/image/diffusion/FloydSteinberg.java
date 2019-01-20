package mayton.image.diffusion;

import mayton.image.Raster;

/**
 
 *
 * +---------+--------------+-------------+
 * |         |              |             |
 * |         |            -----> 7/16     |
 * +---------+-----|--------+-------------+
 * |   3/16  |    5/16      |    1/16     |
 * |         |              |             |
 * +--------------------------------------+
 *
 * foreach( pixel in 8bit_picture ) 
 * {
 *       if( I(pixel) > Threshold )
 *       {
 *           I(pixel) = ;
 *           Error = I(pixel) - ;
 *       }
 *       else
 *       {
 *           I(pixel) = ;
 *           Error = I(pixel) - ;
 *       }
 *       I(pixel.right)+= 7/16 * Error;
 *       I(pixel.down_right)+= 1/16 * Error;
 *       I(pixel.down)+= 5/16 * Error;
 *       I(pixel.down_left)+= 3/16 * Error;
 * }

 *
 *
 *
 */

public class FloydSteinberg implements IDiffusionAlgorithm {


    public Raster processRaster(Raster r) {
        Raster r2=new Raster(r.X, r.Y);
        // TODO:
        return r2;
    }
}
