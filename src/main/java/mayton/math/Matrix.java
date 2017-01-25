package mayton.math;

import java.text.DecimalFormat;

/**
 * 05.11.2006  mayton
 *
 *
 *  ISize
 *    |
 *    +- IMatrix
 *    |      |
 *    |      +- IWriteableMatrix
 *    |
 *    +- INumericMatrix
 *    |      |
 *    |      +- IWriteableNumericMatrix
 *    |
 *    +- IMatrixTemplate <conttype>
 *           |
 *           +- IWriteableMatrixTemplate <conttype>
 *
 *
 *
 *  Object
 *    |
 *    |
 *    +- AdapterMatrixTransp : IMatrix
 *    |
 *    +- AdapterMatrixTorus : IMatrix
 *    |
 *    +- Matrix : IMatrix
 *    |      |
 *    |      +- MatrixAdjacent : IWriteableMatrix
 *    |      +- MatrixDiagonal : IWriteableMatrix
 *    |      +- MatrixDCT
 *    |      +- MatrixDither
 *    |      +- MatrixGauss
 *    |      +- MatrixGeneric : IWriteableMatrix
 *    |
 *    |
 *    +- MatrixAdapterAvg : IMatrix
 *    |
 *    +- MatrixNumeric : INumericMatrix
 *    |      |
 *    |      +- MatrixQuantizationJPEGChrominance
 *    |      +- MatrixQuantizationJPEGLuminance
 *    |
 *    +- MatrixQuantization : INumericMatrix
 *
 *
 *
 */


public class Matrix implements IMatrix
{
    protected  double[][] m=null;

    protected  int X=0;
    protected  int Y=0;

    protected  int msize=0;

    public Matrix()
	{
		
	}

    public double get(int x,int y)
    {
        return m[x][y];
    }

    public int getX()
    {
        return X;
    }

    public int getY()
    {
        return Y;
    }

    /**
     * ��������� ���� ������
     *
     *  a(k,n) * b(m,k) = c(m,n)
     *
     *  | a(1,1)       a(1,N) |
     *  | ....................|
     *  | a(K,1) ....  a(K,N) |
     *
     *
     * @param a
     * @param b
     * @return �����������
     */
    public static Matrix mul(IMatrix a,IMatrix b){
        assert(a.getX()==b.getY());
        MatrixGeneric c=new MatrixGeneric(a.getY(),b.getX());
        for(int i=0;i<a.getX();i++)
        {
            for(int j=0;j<b.getY();j++)
            {
                double prod=0.0;
                for(int k=0;k<a.getX();k++) prod+=a.get(k,i)*b.get(j,k);
                c.set(i,j,prod);
            }
        }
        return c;
    }

    /**
     * ���������� ����� �������
     * @return rank(A)
     */
    public int rank()
    {
        return 0;
    }

    /**
     * ���������� �������� �������
     *
     * @param A
     * @return (A)^-1
     */
    public static MatrixGeneric invert(IMatrix A)
    {
        return null;
    }

    @Override
    public String toString()
	{
		StringBuffer Sb=new StringBuffer("ua.dn.mayton.math.Matrix:\n\n");
		Sb.append("X = "+X+"\n");
		Sb.append("Y = "+Y+"\n\n");
		DecimalFormat Df=new DecimalFormat("-#0.00; #0.00");
		for(int i=0;i<Y;i++)
		{
			Sb.append("|");
			for(int j=0;j<X;j++)
			{
				Sb.append(Df.format(m[j][i]));
				if (j<X-1) Sb.append(" , ");
			}
			Sb.append("|\n");
		}
		return Sb.toString();
	}

}