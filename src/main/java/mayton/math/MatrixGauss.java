package mayton.math;

import static java.lang.Math.*;

/**
 *  ������� ���������� ������������� ������������ ������
 *  
 *  
 */ 

public class MatrixGauss extends Matrix 
{

	protected double sigma=1.0;
    protected int size;


    public MatrixGauss(int size)
	{
        assert(size>0);
        this.size=size;
        sigma=(double)(size/6.0);
	}

	public MatrixGauss(double sigma)
	{           
        this.sigma=sigma;
        size=(int)(sigma*6.0);
    }

	public double get(int X,int Y)
	{
		return exp(-(X*X+Y*Y)/(2.0*sigma));
	}

    public int getX() {
        return size;
    }

    public int getY() {
        return size;
    }

}
