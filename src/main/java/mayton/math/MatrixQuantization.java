package mayton.math;

import java.text.DecimalFormat;
import java.lang.String;

/**
 * ������� ����������� ��� JPEG-��������������
 */

public class MatrixQuantization implements INumericMatrix {

    int size;

    int q = 2;

    int[] m;

    public int getY() {
        return size;
    }

    public int getX() {
        return size;
    }

    public int get(int X, int Y) throws IndexOutOfBoundsException {
        return m[X + Y * size];
    }

    public MatrixQuantization(int size) {
        this.size = size;
        m = new int[size * size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m[size * i + j] = 1 + ((1 + i + j) * q);
            }
        }
    }

    public MatrixQuantization(int size, int q) {
        this.q = q;
        this.size = size;
        m = new int[size * size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m[size * i + j] = 1 + ((1 + i + j) * q);
            }
        }
    }

    public String toString() {

        StringBuilder sb = new StringBuilder("ua.dn.mayton.math.MatrixQuantization:\n\n");
        sb.append("size = " + size + "\n\n");
        int j;
        for (int i = 0; i < size; i++) {
            if (i == size / 2)
                sb.append("Quantization = |");
            else
                sb.append("               |");
            for (j = 0; j < size - 1; j++) {
                sb.append(String.format("%5d", m[j + i * size]));
                sb.append(" , ");
            }
            sb.append(String.format("%5d", m[j + i * size]));
            sb.append("|\n");
        }
        return sb.toString();
    }
}
