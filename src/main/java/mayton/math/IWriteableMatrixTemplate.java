package mayton.math;


public interface IWriteableMatrixTemplate <conttype> extends IMatrixTemplate<conttype> {

    public void set(int x,int y,conttype v) throws IndexOutOfBoundsException;

}
