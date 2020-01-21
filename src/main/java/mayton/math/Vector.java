package mayton.math;

import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

import static java.lang.Math.*;

@Immutable
@ThreadSafe
public class Vector extends Hypercomplex{

    public final double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public @NotNull Vector sum(@NotNull Vector r) {
        return new Vector(x + r.x, y + r.y, z + r.z);
    }

    public @NotNull Vector prod(double r) {
        return new Vector(x * r, y * r, z * r);
    }

    public double sprod(@NotNull Vector r) {
        return x * r.x + y * r.y + z * r.z;
    }

    public @NotNull Vector vprod(@NotNull Vector r) {
        return new Vector(y * r.z - z * r.y,
                z * r.x - x * r.z,
                x * r.y - y * r.x);
    }

    public @NotNull Vector norm() {
        return this.prod(1.0 / sqrt(this.sprod(this)));
    }

    @Override
    public double getModule() {
        return sqrt(x * x + y * y + z * z);
    }
}
