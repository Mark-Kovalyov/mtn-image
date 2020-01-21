package mayton.math;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

@Immutable
@ThreadSafe
public final class Octonion extends Hypercomplex {

    public double a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;
    public double g;
    public double h;

    public Octonion(Octonion o) {
        this.a=o.a;
        this.b=o.b;
        this.c=o.c;
        this.d=o.d;
        this.e=o.e;
        this.f=o.f;
        this.g=o.g;
        this.h=o.h;
    }

    public Octonion(double a, double b, double c, double d, double e, double f, double g, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Octonion(a,b,c,d,e,f,g,h);
    }

    public void add(Octonion o)
    {
        this.a+=o.a;
        this.b+=o.b;
        this.c+=o.c;
        this.d+=o.d;
        this.e+=o.e;
        this.f+=o.f;
        this.g+=o.g;
        this.h+=o.h;
    }

    @Override
    public String toString() {
        return String.format("(%f,%f,%f,%f,%f,%f,%f,%f)",a,b,c,d,e,f,g,h);
    }

    @Override
    public double getModule() {
        return Math.sqrt(a * a + b * b + c * c + d * d + e * e + f * f + g * g + h * h);
    }


}
