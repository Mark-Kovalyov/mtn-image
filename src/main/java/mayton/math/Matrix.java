package mayton.math;

import java.text.DecimalFormat;

/**
 * 05.11.2006  mayton
 */
public class Matrix implements IMatrix {

    // TODO: Refactor this bullshit with 1-dimension array
    protected double[][] m = null;

    protected int X = 0;
    protected int Y = 0;

    protected int msize = 0;

    public Matrix() {

    }

    public double get(int x, int y) {
        return m[x][y];
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    /**
     *
     * <p>
     * a(k,n) * b(m,k) = c(m,n)
     * <p>
     * | a(1,1)       a(1,N) |
     * | ....................|
     * | a(K,1) ....  a(K,N) |
     *
     * @param a
     * @param b
     * @return
     */
    public static Matrix mul(IMatrix a, IMatrix b) {
        assert a.getX() == b.getY();
        MatrixGeneric c = new MatrixGeneric(a.getY(), b.getX());
        for (int i = 0; i < a.getX(); i++) {
            for (int j = 0; j < b.getY(); j++) {
                double prod = 0.0;
                for (int k = 0; k < a.getX(); k++) prod += a.get(k, i) * b.get(j, k);
                c.set(i, j, prod);
            }
        }
        return c;
    }

    /**
     * @return rank(A)
     */
    public int rank() {
        return 0;
    }

    /**
     * @param A
     * @return (A)^-1
     */
    public static MatrixGeneric invert(IMatrix A) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ua.dn.mayton.math.Matrix:\n\n");
        sb.append("X = " + X + "\n");
        sb.append("Y = " + Y + "\n\n");
        DecimalFormat decimalFormat = new DecimalFormat("-#0.00; #0.00");
        for (int i = 0; i < Y; i++) {
            sb.append("|");
            for (int j = 0; j < X; j++) {
                sb.append(decimalFormat.format(m[j][i]));
                if (j < X - 1) sb.append(" , ");
            }
            sb.append("|\n");
        }
        return sb.toString();
    }

}