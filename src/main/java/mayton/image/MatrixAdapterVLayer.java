package mayton.image;

import mayton.math.IMatrix;

/**
 * Created by IntelliJ IDEA.
 * User: mayton
 * Date: 02.04.2007
 * Time: 1:44:55
 * To change this template use File | Settings | File Templates.
 */
public class MatrixAdapterVLayer implements IMatrix {

    Raster rs=null;

    public MatrixAdapterVLayer(Raster rs) {
        assert(rs!=null);
        this.rs=rs;
    }


    @Override
    public double get(int x, int y) throws IndexOutOfBoundsException {
        assert(x<rs.X);
        assert(y<rs.Y);
        assert(x>=0);
        assert(y>=0);
        return rs.getVPixelDouble(x,y);
    }

    @Override
    public int getY() {
        return rs.Y;
    }

    @Override
    public int getX() {
        return rs.X;
    }
}
