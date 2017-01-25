package mayton.image.iterators;

import mayton.math.Matrix;
import mayton.math.MatrixGeneric;

/**
 * Created by IntelliJ IDEA.
 * User: mayton
 * Date: 13.12.2006
 * Time: 15:51:52
 * To change this template use File | Settings | File Templates.
 */
public class FrequencyPixIterator implements IPixIterator {
    Matrix m;
    int[] x;
    int[] y;
    int size;
    int count = 0;

    public void updateMatrix(Matrix m) {
        if (m == null) {
            //m=new MatrixGeneric(m.X,m.Y);
        }
    }

    public void commit() {

    }

    public int getX() {
        return x[count];
    }

    public int getY() {
        return y[count];
    }

    public boolean next() {
        if (count < size) {
            count++;
            return true;
        }
        return false;
    }

    public void reset() {
        count = 0;
    }
}
