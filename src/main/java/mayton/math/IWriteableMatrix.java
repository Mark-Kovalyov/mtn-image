package mayton.math;

public interface IWriteableMatrix extends IMatrix {

    void set(int x, int y, double v) throws IndexOutOfBoundsException;

}