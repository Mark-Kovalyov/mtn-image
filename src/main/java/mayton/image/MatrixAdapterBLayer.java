package mayton.image;

import mayton.math.IMatrix;

/**
 * Created by IntelliJ IDEA.
 * User: Mayton
 * Date: 08.04.2007
 * Time: 11:21:04
 * To change this template use File | Settings | File Templates.
 */
public class MatrixAdapterBLayer implements IMatrix {

    Raster rs=null;

    public MatrixAdapterBLayer(Raster rs) {
        assert(rs!=null);
        this.rs=rs;
    }

    @Override
    public double get(int x, int y) throws IndexOutOfBoundsException {
        assert(x<rs.X);
        assert(y<rs.Y);
        assert(x>=0);
        assert(y>=0);
        return rs.getBPixel(x,y)/255.0;
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
