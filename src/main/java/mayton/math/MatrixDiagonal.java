package mayton.math;

import static java.lang.Math.*;

/**
 *  Class: Matrix Diagonal 1.0 (JDK 1.5.x)
 *  
 *  ������������ �������
 *   + �� ���� ������ ������ 
 *   + ��� ��������� ������������ �������
 *   + ��� ������� ������ � �������������� ���� �������� ����������
 */ 

public class MatrixDiagonal extends Matrix implements IWriteableMatrix 
{
	//protected int msize;

	protected double[] diagonalVector;

    @Override
	public int getX()
	{
		return msize;
	}	

    @Override
	public int getY()
	{
		return msize;
	}	       

	public MatrixDiagonal(int size)
	{
		msize=size;
		diagonalVector=new double[size];
		for(int k=0;k<size;k++) diagonalVector[k]=1.0;
	}


	public MatrixDiagonal()
	{
		msize=1;
		diagonalVector=new double[1];
		diagonalVector[0]=1.0;
	}

        @Override
	public double get(int x,int y)
	{
		if ((x==y)&&(x>=0)&&(x<msize))
		{
			return diagonalVector[x];
		}
		else
		{
			return 0.0;
		}
	}

	public void set(int x,int y,double v)
	{
		if ((x==y)&&(x>=0)&&(x<msize))
		{
			diagonalVector[x]=v;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}


}
