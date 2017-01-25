package mayton.math;

public interface IWriteableMatrix extends IMatrix
{
	public void set(int x,int y,double v) throws IndexOutOfBoundsException;
}