package mayton.image.iterators;

import static java.lang.Math.*;

/**
 *
 *  2006-12-12   ������ min, max ���������� � ������ ������������ ����. �������
 * 
 */

public class LinearPixIterator implements IPixIterator
{

    @Override
    public String toString() {
        return String.format("x=%d,y=%y",x,y);
    }
	protected int x=0;
	protected int y=0;
	protected int x2;
	protected int y2;
	protected int x1;
	protected int y1;
	protected boolean stop;

	public LinearPixIterator(int width,int height)
	{
		x1=min(0,width);
		y1=min(0,height);
		x2=max(0,width);
		y2=max(0,height);
		reset();
	}

	public LinearPixIterator(int x1,int y1,int x2,int y2)
	{
		this.x1=min(x1,x2);
		this.y1=min(y1,y2);
		this.x2=max(x1,x2);
		this.y2=max(y1,y2);
		reset();
	}


	public int getX()
	{
		return x;
	}	

    @Override
	public int getY()
	{
		return y;
	}

    @Override
	public void reset()
	{
		x=x1-1;
		y=y1;
		stop=false;
	}

    @Override
	public boolean next()
	{
		if (stop) return false;
		x++;
		if (x==x2)
		{
			x=x1;
			y++;
			if (y==y2)
			{
				y--;
				stop=true;
				return false;
			}
		}
		return true;
	}
	
}