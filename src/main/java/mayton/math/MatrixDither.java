package mayton.math;

public class MatrixDither extends Matrix {

    private static MatrixDither instance = new MatrixDither();

    private static double k[][] =
            {{0.0, 8.0, 2.0, 10.0},
                    {12.0, 4.0, 14.0, 6.0},
                    {3.0, 11.0, 1.0, 9.0},
                    {15.0, 7.0, 13.0, 5.0}};

    private MatrixDither() {
        X = 4;
        Y = 4;
    }

    public static MatrixDither getInstance() {
        return instance;
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public int getY() {
        return Y;
    }

    @Override
    public double get(int x, int y) throws IndexOutOfBoundsException {
        return k[x][y];
    }
}
