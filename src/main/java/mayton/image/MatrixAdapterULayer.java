package mayton.image;

import mayton.math.IMatrix;

/**
 * Created by IntelliJ IDEA.
 * User: mayton
 * Date: 02.04.2007
 * Time: 1:29:33
 * To change this template use File | Settings | File Templates.
 */
public class MatrixAdapterULayer implements IMatrix {

    Raster rs=null;

    public MatrixAdapterULayer(Raster rs) {
        assert(rs!=null);
        this.rs=rs;
    }

    @Override
    public double get(int x, int y) throws IndexOutOfBoundsException {
        assert(x<rs.X);
        assert(y<rs.Y);
        assert(x>=0);
        assert(y>=0);
        return rs.getUPixelDouble(x,y);
    }

    @Override
    public int getX() {
        return rs.X;
    }

    @Override
    public int getY() {
        return rs.Y;
    }

    @Override
    public String toString()
    {
        StringBuffer Sb=new StringBuffer("DUMP of ua.dn.mayton.image.MatrixAdapterULayer:\n");
        Sb.append("X             = "+getX()+"\n");
        Sb.append("Y             = "+getY()+"\n");        
        return Sb.toString();
    }
}
