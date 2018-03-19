package mayton.math;

import javax.annotation.Nonnull;

import static java.lang.Math.atan2;
import static java.lang.Math.hypot;

public class Complex extends Hypercomplex implements Comparable {

    public double a;
    public double b;

    @Nonnull
    public static Complex sum(@Nonnull Complex arg1,@Nonnull Complex arg2) {
        return new Complex(arg1.a + arg2.a, arg1.b + arg2.b);
    }

    @Nonnull
    public static Complex mul(@Nonnull Complex arg1,@Nonnull Complex arg2) {
        return new Complex(
                arg1.a * arg2.a - arg1.b * arg2.b,
                arg1.a * arg2.b + arg1.b * arg2.a);
    }

    @Nonnull
    public static Complex div(@Nonnull Complex c1,@Nonnull Complex c2) {
        double d = c2.a * c2.a + c2.b * c2.b;
        return new Complex(
                (c1.a * c2.a + c1.b * c2.b) / d,
                (c1.b * c2.a - c1.a * c2.b) / d);
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

    public void add(@Nonnull Complex c) {
        this.a += c.a;
        this.b += c.b;
    }

    public double getArg() {
        return atan2(b, a);
    }

    @Override
    public double getModule() {
        return hypot(a, b);
    }


    public int compareTo(Object o) {
        throw new RuntimeException("Not implemented");
    }
}
