package mayton.math;

public interface INumericMatrix extends ISize {

    int get(int x, int y) throws IndexOutOfBoundsException;

}
