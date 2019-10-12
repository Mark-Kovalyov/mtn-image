package mayton.image.iterators;

public interface IPixIterator {
	int getX();
	int getY();
	boolean next();
	void reset();
}