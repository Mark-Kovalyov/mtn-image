package mayton.math;

public interface IMatrix extends ISize
{       
    public double get(int x,int y) throws IndexOutOfBoundsException;
}