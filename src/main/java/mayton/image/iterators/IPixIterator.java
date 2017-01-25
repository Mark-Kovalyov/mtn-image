package mayton.image.iterators;

public interface IPixIterator
{
	public int getX();
	public int getY();
	public boolean next();
	public void reset();
}