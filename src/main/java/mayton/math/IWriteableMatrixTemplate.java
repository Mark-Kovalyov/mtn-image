package mayton.math;


public interface IWriteableMatrixTemplate<C> extends IMatrixTemplate<C> {

    void set(int x, int y, C v) throws IndexOutOfBoundsException;

}
