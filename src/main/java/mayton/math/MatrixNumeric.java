package mayton.math;

import java.text.DecimalFormat;

public class MatrixNumeric implements INumericMatrix {

    protected int[][] m = null;
    protected int X;
    protected int Y;

    public MatrixNumeric() {
        this.X = 1;
        this.Y = 1;
        m = new int[1][1];
    }

    public MatrixNumeric(int x, int y) {
        this.X = x;
        this.Y = y;
        m = new int[x][y];
    }

    public int get(int x, int y) throws IndexOutOfBoundsException {
        return m[x][y];
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("ua.dn.mayton.math.MatrixNumeric:\n\n");
        sb.append("X = " + X + "\n");
        sb.append("Y = " + Y + "\n\n");
        DecimalFormat Df = new DecimalFormat("-#00000; #00000");
        for (int i = 0; i < Y; i++) {
            sb.append("|");
            for (int j = 0; j < X; j++) {
                sb.append(Df.format(m[j][i]));
                if (j < X - 1) sb.append(" , ");
            }
            sb.append("|\n");
        }
        return sb.toString();
    }
}
