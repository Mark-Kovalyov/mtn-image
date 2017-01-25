package mayton.image.iterators;

public class ShakerPixIterator implements IPixIterator
{

	protected int x=0;
	protected int y=0;
	protected int x2;
	protected int y2;
	protected int x1;
	protected int y1;
	protected boolean stop;
	protected int delta=1;

	public ShakerPixIterator(int width,int height)
	{
		x1=Math.min(0,width);
		y1=Math.min(0,height);
		x2=Math.max(0,width);
		y2=Math.max(0,height);
		reset();
	}

	public ShakerPixIterator(int x1,int y1,int x2,int y2)
	{
		this.x1=Math.min(x1,x2);
		this.y1=Math.min(y1,y2);		
		this.x2=Math.max(x1,x2);
		this.y2=Math.max(y1,y2);
		reset();
	}

	public int getX()
	{
		return x;
	}	

	public int getY()
	{
		return y;
	}

	public void reset()
	{
		x=x1-1;
		y=y1;
		delta=1;
		stop=false;
	}

	public boolean next()
	{

		if (stop) return false;

		x+=delta;

		if (delta>0)
		{
			if (x>=x2)
			{
				delta=-1;
				x=x2-1;
				y++;
				if (y>=y2)
				{
					y=y2-1;
					stop=true;
					return false;
				}
			}			
		}
		else
		{
			if (x<x1)
			{
				delta=1;
				x=x1;
				y++;
				if (y>=y2)
				{
					y=y2-1;
					stop=true;
					return false;
				}
			}
		}

		return true;
	}
	
}