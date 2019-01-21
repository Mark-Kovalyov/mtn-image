package mayton.math;

/**
 * User: mayton
 * Date: 08.04.2007
 * Time: 19:45:26
 */
public class MatrixAdapterAvg implements IMatrix {

    protected int X;
    protected int Y;
    protected IMatrix m;
    protected int ratio = 2;

    public MatrixAdapterAvg(IMatrix m, int ratio) {
        assert ratio > 1;
        this.ratio = ratio;
        this.m = m;
        X = m.getX() / ratio;
        Y = m.getY() / ratio;
    }

    public MatrixAdapterAvg(IMatrix m) {
        this.m = m;
        X = m.getX() / 2;
        Y = m.getY() / 2;
    }

    @Override
    public double get(int x, int y) {
        assert x < this.X;
        assert y < this.Y;
        assert x >= 0;
        assert y >= 0;
        double sum = 0.0;
        if (ratio == 2) {
            int xx = x * 2;
            int yy = y * 2;
            sum = 0.25 * (m.get(xx, yy) +
                    m.get(xx + 1, yy) +
                    m.get(xx, yy + 1) +
                    m.get(xx + 1, yy + 1));
        } else {
            int xx = x * ratio;
            int yy = y * ratio;
            for (int k = 0; k < ratio; k++)
                for (int j = 0; j < ratio; j++) {
                    sum += m.get(xx + k, yy + j);
                }
            sum /= (double) (ratio * ratio);
        }
        return sum;
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public int getY() {
        return Y;
    }
}
