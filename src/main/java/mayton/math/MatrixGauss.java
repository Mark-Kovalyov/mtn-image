package mayton.math;

import static java.lang.Math.*;

public class MatrixGauss implements IMatrix {

    protected double sigma = 1.0;
    protected int size;

    public MatrixGauss(int size, double sigma) {
        assert (size > 0);
        this.size = size;
        this.sigma = sigma;
    }

    public double get(int X, int Y) {
        return exp(-(X * X + Y * Y) / (2.0 * sigma));
    }

    public int getX() {
        return size;
    }

    public int getY() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                stringBuilder.append(String.format("%.8f ", get(x,y)));
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
