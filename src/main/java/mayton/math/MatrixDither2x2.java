package mayton.math;


public class MatrixDither2x2 extends Matrix {

    private static double k[][] =
            {};

    private MatrixDither2x2() {
        X = 2;
        Y = 2;
    }

    private static MatrixDither2x2 ourInstance = new MatrixDither2x2();

    public static MatrixDither2x2 getInstance() {
        return ourInstance;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public double get(int x, int y) throws IndexOutOfBoundsException {
        return k[x][y];
    }

}
