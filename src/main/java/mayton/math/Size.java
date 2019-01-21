package mayton.math;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class Size implements ISize {

    final int x;
    final int y;

    public Size(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

}
