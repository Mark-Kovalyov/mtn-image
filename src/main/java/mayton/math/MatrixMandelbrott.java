package mayton.math;



/**
 * Множество Мандельбротта
 * @author mayton
 */
public class MatrixMandelbrott implements IMatrix
{
    protected int quantity;

    protected int X;
    protected int Y;

    /**
     *
     * @param x
     * @param y
     * @param quantity - точность [0..inf]
     */
    public MatrixMandelbrott(int x,int y,int quantity)
    {
        X=x;
        Y=y;
        this.quantity=quantity;
    }

    public double get(int x, int y) throws IndexOutOfBoundsException
    {
        Complex Z1=new Complex(0,0);
        Complex Z2=new Complex(0,0);
        
        int c=0;

        for(int i=0;i<quantity;i++)
        {
            Complex Z3=new Complex((double)x,(double)y);
            Z2=Complex.sum(Complex.mul(Z1, Z1),Z3);
            if (Z2.getModule()>2.0) break;
            c++;
            Z1=Z2;
        }

        return c/(double)quantity;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
