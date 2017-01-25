package mayton.math;

public interface INumericMatrix extends ISize
{
    public int get(int x,int y) throws IndexOutOfBoundsException;
}
