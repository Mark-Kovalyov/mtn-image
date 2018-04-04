package mayton.image;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class Fpoint {

    public final double x;
    public final double y;

    public Fpoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return String.format("(%f,%f)", x, y);
    }
}
