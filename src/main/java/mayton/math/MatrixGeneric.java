package mayton.math;

import java.lang.Math.*;
import java.text.*;
import java.util.*;

/**
 *
 *  05.11.2006 mayton
 *
 */ 

public class MatrixGeneric extends Matrix implements IWriteableMatrix
{

    public MatrixGeneric(IMatrix arg)
	{
        assert(arg!=null);
        this.X=arg.getX();
		this.Y=arg.getY();
		this.msize=X*Y;
		m=new double[X][Y];
		for(int x=0;x<X;x++) for(int y=0;y<Y;y++) m[x][y]=arg.get(x,y);
	}


    public MatrixGeneric(IMatrix arg,int xpos,int ypos,int size)
	{
        assert(arg!=null);
        assert(xpos>=0);
        assert(xpos>=0);
        assert(size>0);
        this.X=size;
		this.Y=size;
		this.msize=X*Y;
		m=new double[X][Y];
		for(int x=0;x<size;x++)
        {
            for(int y=0;y<size;y++) m[x][y]=arg.get(x+xpos,y+ypos);
        }
    }

    /**
     * ����������� ��������� ������� ������� size
     *
     * @param size
     */

    public MatrixGeneric(int size)
	{
        assert(size>0);
        this.X=size;
		this.Y=size;
		msize=size*size;
		m=new double[X][Y];
		for(int x=0;x<X;x++) for(int y=0;y<Y;y++) m[x][y]=1.0;		
	}

    /**
     * ����� ����������� �������. ��� ���� ��������������� ������.
     *
     * @param X
     * @param Y
     */

    public MatrixGeneric(int X,int Y)
	{
		this.X=X;
		this.Y=Y;
		msize=X*Y;
		m=new double[X][Y];
		for(int x=0;x<X;x++) for(int y=0;y<Y;y++) m[x][y]=0.0;
	}

	public MatrixGeneric(int X,int Y,Enumeration InitStream)
	{
		this.X=X;
		this.Y=Y;
		msize=X*Y;
		m=new double[X][Y];
		for(int x=0;x<X;x++) for(int y=0;y<Y;y++) m[x][y]=((Double)InitStream.nextElement()).doubleValue();
	}

	public MatrixGeneric()
	{
		this.X=1;
		this.Y=1;
		msize=1;
		m=new double[X][Y];
		m[0][0]=1.0;
	}

    protected Object clone() throws CloneNotSupportedException {
        return new MatrixGeneric(this);
    }

	public void set(int x,int y,double v) throws IndexOutOfBoundsException
	{
		if ((x>=0)&&(x<X)&&(y>=0)&&(y<Y))
		{
			m[x][y]=v;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}



    /**
     * ��������� ������ �� �������� ��������� �������. C����� ������� A, ����������
     * �� ������� ������� B.
     *
     *  [A]*[B]=[C]
     *
     * @param A
     * @param B
     * @return C
     */
    public static MatrixGeneric mul(IMatrix A,IMatrix B)
    {
        assert(A!=null);
        assert(B!=null);
        assert(A.getX() == B.getY());

        MatrixGeneric temp=new MatrixGeneric(A.getX(),B.getY());

        for(int i=0;i<temp.getY();i++)
        {
               for(int j=0;j<temp.X;j++)
               {
                     double sum=0.0;
                     for(int k=0;k<A.getY();k++) sum+=(A.get(k,j)*B.get(i,k));
                     temp.set(j,i,sum);
               }
        }

        return temp;
    }

    /**
     *
     * [A] := [A]*[B]
     *
     * @param B
     */
    public void mul(IMatrix B)
    {
        assert(B!=null);
        assert(this.getX() == B.getY());
        MatrixGeneric temp=new MatrixGeneric(this.getX(),B.getY());
        this.X=temp.getX();
        this.Y=temp.getY();
        for(int x=0;x<X;x++) for(int y=0;y<Y;y++) m[x][y]=temp.get(x,y);
    }

    
	
}
