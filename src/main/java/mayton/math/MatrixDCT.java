package mayton.math;

import java.text.*;
import java.lang.*;
import static java.lang.Math.*;


/**
 *  
 *  <pre>
 * 
 *  DCT   = 1/sqr(N), ���� i=0
 *     ij
 *  DCT   = sqr(2/N)*cos[(2j+1)*i*3.14/2N], ���� i > 0
 *     ij
 *
 *  </pre>
 *
 *  05.11.2006               mayton
 *
 *
 *
 */ 

public class MatrixDCT extends Matrix 
{
	protected int n;

	//protected double[][] m;

	public MatrixDCT()
	{
		this.n=8;
		m=new double[n][n];
		double sqrn=sqrt((double)n);
		for(int i=0;i<n;i++) 
		{
			for(int j=0;j<n;j++) 
			{	
				if (i==0) m[i][j]=1.0/sqrn;
				else m[i][j]=sqrt(2.0/n)*cos((2*j+1)*i*PI/(2.0*n));
			}
		}		
	}

	public MatrixDCT(int n)
	{
		this.n=n;
		m=new double[n][n];
		double sqrn=Math.sqrt((double)n);
		for(int i=0;i<n;i++) 
		{
			for(int j=0;j<n;j++) 
			{	
				if (i==0) m[i][j]=1.0/sqrn;
				else m[i][j]=sqrt(2.0/n)*cos((2*j+1)*i*PI/(2.0*n));
			}
		}
	}


    @Override
	public double get(int X,int Y) throws IndexOutOfBoundsException
	{
		if ((X>=0)&&(X<n)&&(Y>=0)&&(Y<n))
		{
			return m[X][Y];
		}
		else
		{
			throw new IndexOutOfBoundsException();			
		}
	}

    @Override
	public int getY()
	{
		return n;
	}

    @Override
	public int getX()
	{
		return n;
	}

    @Override
	public String toString()
	{
		StringBuffer Sb=new StringBuffer("ua.dn.mayton.math.MatrixDCT:\n\n");

		Sb.append("size = "+n+"\n\n");

		DecimalFormat Df=new DecimalFormat("-#0.000000; #0.000000");

		for(int i=0;i<n;i++)
		{
            if (i==n/2){
                Sb.append("   DCT = |");
            }
            else
            {
                Sb.append("         |");
            }
            for(int j=0;j<n;j++)
			{		
				Sb.append(Df.format(m[j][i]));
				if (j<n-1) Sb.append(" , ");
			}
			Sb.append("|\n");
		}
        Sb.append("\n");

        return Sb.toString();
	}

}
