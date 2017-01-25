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

    public MatrixAdapterYLayer(Raster rs)
    {
        assert(rs!=null);
        this.rs=rs;
    }

    /**
     *
     * @param x
     * @param y
     * @return Y ��������, ������������� � �������� [0..255.0]
     * @throws IndexOutOfBoundsException
     */
    @Override
    public double get(int x, int y) throws IndexOutOfBoundsException {
        assert(x<rs.X);
        assert(y<rs.Y);
        assert(x>=0);
        assert(y>=0);
        return rs.getYPixelDouble(x,y);
    }

}
