package mayton.image;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public final class Point {

    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
