package mayton.math;


public class Quaternion extends Hypercomplex implements Cloneable, Comparable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Quaternion(a,b,c,d);
    }

    public double a,b,c,d;

    public Quaternion(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Quaternion(Quaternion q) {
        this.a = q.a;
        this.b = q.b;
        this.c = q.c;
        this.d = q.d;
    }

    @Override
    public String toString() {
        return String.format("(%f,%f,%f,%f)", a,b,c,d);
    }

    public static Quaternion sum(Quaternion q1,Quaternion q2)
    {
        return new Quaternion(q1.a+q2.a,q1.b+q2.b,q1.c+q2.c,q1.d+q2.d);
    }

    public static Quaternion mul(Quaternion q1,Quaternion q2)
    {
        //throw new UnsupportedOperationException("Not supported yet.");

        return new Quaternion(
                q1.a*q2.a + q1.a*q2.b + q1.a*q2.c + q1.a*q2.d,
                q1.a*q2.b + q1.b*q2.a + q1.c*q2.d - q1.d*q2.c,
                q1.a*q2.c + q1.b*q2.d + q1.a*q2.c + q1.d*q2.b,
                q1.a*q2.d + q1.b*q2.c + q1.c*q2.b + q1.d*q2.a
        );
        
    }

    public Quaternion getNorm(Quaternion q)
    {
        double norm=q.getModule();
        return new Quaternion(q.a/norm,q.b/norm,q.c/norm,q.d/norm);
    }

    @Override
    public double getModule() {
        return Math.sqrt(this.a*this.a+this.b*this.b+this.c*this.c+this.d*this.d);
    }

    @Override
    public double getArg() {

        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }





}
