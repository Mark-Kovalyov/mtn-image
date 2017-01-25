package mayton.image;

import mayton.math.IMatrix;

/**
 * Created by IntelliJ IDEA.
 * User: mayton
 * Date: 08.04.2007
 * Time: 11:18:58
 * To change this template use File | Settings | File Templates.
 */
public class MatrixAdapterGLayer implements IMatrix {

    Raster rs=null;

    public MatrixAdapterGLayer(Raster rs) {
        assert(rs!=null);
        this.rs=rs;
    }

    @Override
    public double get(int x, int y) throws IndexOutOfBoundsException {
        assert(x<rs.X);
        assert(y<rs.Y);
        assert(x>=0);
        assert(y>=0);
        return rs.getGPixel(x,y)/255.0;
    }

    @Override
    public int getX() {
        return rs.X;
    }

    @Override
    public int getY() {
        return rs.Y;
    }
}
