package mayton.image.iterators;

import static java.lang.Math.*;

import java.awt.Rectangle;

public class StepFrameIterator implements IPixIterator {

    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected int xstep;
    protected int ystep;

    LinearPixIterator lpi;

    /**
     *
     * @param x1    ����� ������� ����
     * @param y1    ����� ������� ����
     * @param x2    ������ ������ ����
     * @param y2    ������ ������ ����
     * @param xstep ��� �� �����������
     * @param ystep ��� �� ���������
     *
     */

    public StepFrameIterator(int x1,int y1,int x2,int y2,int xstep,int ystep)
    {


	    assert(xstep>0);
	    assert(ystep>0);

        this.x1=min(x1,x2);
        this.y1=min(y1,y2);
        this.x2=max(x1,x2);
        this.y2=max(y1,y2);

	    assert(xstep<this.x2-this.x1);
	    assert(ystep<this.y2-this.y1);

	    this.xstep=xstep;
	    this.ystep=ystep;

	    int width  = (this.x2-this.x1)/xstep;
	    int height = (this.y2-this.y1)/ystep;

	    lpi=new LinearPixIterator(width,height);


    }

    public int getX() {

        return x1+xstep*lpi.getX();

    }

    public int getY() {

        return y1+ystep*lpi.getY();

    }

    public boolean next() {

	    return lpi.next();

    }

    public void reset() {

	    lpi.reset();

    }

    public Rectangle getRectangle()
    {
	    return new Rectangle(getX(),getY(),xstep,ystep);
    }
}