package mayton.math;


import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

import static java.lang.Math.sqrt;

@Immutable
@ThreadSafe
public final class Quaternion extends Hypercomplex {

    public final double a,b,c,d;

    public Quaternion(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Quaternion(@NotNull Quaternion q) {
        this.a = q.a;
        this.b = q.b;
        this.c = q.c;
        this.d = q.d;
    }

    @Override
    public String toString() {
        return String.format("(%f,%f,%f,%f)", a,b,c,d);
    }

    @NotNull
    public static Quaternion sum(@NotNull Quaternion q1,@NotNull Quaternion q2) {
        return new Quaternion(q1.a + q2.a, q1.b + q2.b, q1.c + q2.c, q1.d + q2.d);
    }

    @NotNull
    public static Quaternion mul(@NotNull Quaternion q1,@NotNull Quaternion q2) {
        return new Quaternion(
                q1.a * q2.a + q1.a * q2.b + q1.a * q2.c + q1.a * q2.d,
                q1.a * q2.b + q1.b * q2.a + q1.c * q2.d - q1.d * q2.c,
                q1.a * q2.c + q1.b * q2.d + q1.a * q2.c + q1.d * q2.b,
                q1.a * q2.d + q1.b * q2.c + q1.c * q2.b + q1.d * q2.a
        );
        
    }

    @NotNull
    public Quaternion getNorm(@NotNull Quaternion q) {
        double norm = q.getModule();
        return new Quaternion(q.a / norm, q.b / norm, q.c / norm, q.d / norm);
    }

    @Override
    public double getModule() {
        return sqrt(this.a * this.a + this.b * this.b + this.c * this.c + this.d * this.d);
    }



}
