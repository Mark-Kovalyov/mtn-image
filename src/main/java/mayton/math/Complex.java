package mayton.math;

public class Complex extends Hypercomplex implements Cloneable, Comparable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Complex(a, b);
    }

    public double a;
    public double b;

    public static Complex sum(Complex arg1, Complex arg2) {
        return new Complex(arg1.a + arg2.a, arg1.b + arg2.b);
    }

    public static Complex mul(Complex arg1, Complex arg2) {
        return new Complex(arg1.a * arg2.a - arg1.b * arg2.b, arg1.a * arg2.b + arg1.b * arg2.a);
    }

    public static Complex div(Complex c1, Complex c2) {
        double d = c2.a * c2.a + c2.b * c2.b;
        return new Complex((c1.a * c2.a + c1.b * c2.b) / d, (c1.b * c2.a - c1.a * c2.b) / d);
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex(Complex arg) {
        this.a = arg.a;
        this.b = arg.b;
    }

    public void mul(Complex arg) {
        Complex prod = mul(this, arg);
        a = prod.a;
        b = prod.b;
    }

    public void div(Complex p) {
        Complex temp = div(this, p);
        this.a = temp.a;
        this.b = temp.b;
    }

    public void inverse() {
        a = -a;
        b = -b;
    }

    public void add(Complex c) {
        this.a += c.a;
        this.b += c.b;
    }

    public double getArg() {
        return Math.atan2(b, a);
    }

    @Override
    public double getModule() {
        return Math.hypot(a, b);
    }


    public int compareTo(Object o) {
        // TODO: Implement
        return 0;
    }
}
