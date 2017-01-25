package mayton.math;


public interface IWriteableNumericMatrix extends INumericMatrix 
{
    public void set(int x,int y,double v) throws IndexOutOfBoundsException;
}
