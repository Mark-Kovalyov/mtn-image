package mayton.math;

/**
 */

public class AdapterMatrixTransp implements IMatrix
{
    int xsize;
    int ysize;

    IMatrix A;

    public AdapterMatrixTransp(IMatrix A)
    {
        assert(A!=null);
        xsize=A.getY();
        ysize=A.getX();
        this.A=A;
    }

    public double get(int X, int Y) throws IndexOutOfBoundsException
    {
        assert(X<xsize);
        assert(Y<ysize);
        assert(X>=0);
        assert(Y>=0);
        return A.get(Y,X);
    }

    public int getY() {
        return ysize;
    }

    public int getX() {
        return xsize;
    }
}
