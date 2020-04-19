package mayton.image.standard;

import javax.annotation.concurrent.Immutable;

@Immutable
public class ColorMode {

    public static final ColorMode COLOR_MODE_16M = new ColorMode(16 * 1024 * 1024);

    public int colors;

    public ColorMode(int colors) {
        this.colors = colors;
    }

    public ColorMode() {
        this.colors = 16 * 1024 * 1024;
    }
}
