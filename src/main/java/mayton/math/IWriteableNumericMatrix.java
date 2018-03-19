package mayton.math;


public interface IWriteableNumericMatrix extends INumericMatrix {

    void set(int x, int y, double v) throws IndexOutOfBoundsException;

}
