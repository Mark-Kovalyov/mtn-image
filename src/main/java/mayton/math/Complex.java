package mayton.math;

import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

import static java.lang.Math.atan2;
import static java.lang.Math.hypot;

@Immutable
@ThreadSafe
public final class Complex extends Hypercomplex {

    public final double a;
    public final double b;

    @NotNull
    public static Complex sum(@NotNull Complex arg1,@NotNull Complex arg2) {
        return new Complex(arg1.a + arg2.a, arg1.b + arg2.b);
    }

    @NotNull
    public static Complex mul(@NotNull Complex arg1,@NotNull Complex arg2) {
        return new Complex(
                arg1.a * arg2.a - arg1.b * arg2.b,
                arg1.a * arg2.b + arg1.b * arg2.a);
    }

    @NotNull
    public static Complex div(@NotNull Complex c1,@NotNull Complex c2) {
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
        /*a = prod.a;
        b = prod.b;*/
    }

    public void div(Complex p) {
        Complex temp = div(this, p);
        /*this.a = temp.a;
        this.b = temp.b;*/
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
