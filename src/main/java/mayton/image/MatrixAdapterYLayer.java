package mayton.image;

import mayton.math.IMatrix;

/**
 *   05.11.2006 ........... IMatrix .. Ratsr:
 *
 *                 - MatrixAdapterY
 *                 - MatrixAdapterU
 *                 - MatrixAdapterV
 */

public class MatrixAdapterYLayer implements IMatrix {

    Raster rs=null;

    @Override
    public int getX() {
        return rs.X;
    }

    @Override
    public int getY() {
        return rs.Y;
    }

    public MatrixAdapterYLayer(Raster rs) {
        this.rs=rs;
    }

    @Override
    public double get(int x, int y) throws IndexOutOfBoundsException {
        return rs.getYPixelDouble(x,y);
    }

}
