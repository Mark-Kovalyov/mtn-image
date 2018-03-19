package mayton.math;

public class MatrixDither4x4 extends Matrix {

    // TODO: Refactor with  1-dimension array
    private static double k[][] =
            {{0.0, 8.0, 2.0, 10.0},
             {12.0, 4.0, 14.0, 6.0},
             {3.0, 11.0, 1.0, 9.0},
             {15.0, 7.0, 13.0, 5.0}};

    private MatrixDither4x4() {
        X = 4;
        Y = 4;
    }

    private static MatrixDither4x4 ourInstance = new MatrixDither4x4();

    public static MatrixDither4x4 getInstance() {
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
