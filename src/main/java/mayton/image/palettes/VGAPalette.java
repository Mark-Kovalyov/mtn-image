package mayton.image.palettes;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class VGAPalette implements IPalette {
    private static VGAPalette ourInstance = new VGAPalette();

    private static List<Color> pal;

    public static VGAPalette getInstance() {
        return ourInstance;
    }

    private VGAPalette() {
        pal = new ArrayList<>();

        int r, g, b;

        pal.add(new Color(0x000000));
        pal.add(new Color(0x0000FF));
        pal.add(new Color(0x00FF00));
        pal.add(new Color(0x00FFFF));

        pal.add(new Color(0xFF0000));
        pal.add(new Color(0xFF00FF));
        pal.add(new Color(0xFFFF00));
        pal.add(new Color(0xFFFFFF));

        pal.add(new Color(0x000000));
        pal.add(new Color(0x000080));
        pal.add(new Color(0x008000));
        pal.add(new Color(0x008080));

        pal.add(new Color(0x800000));
        pal.add(new Color(0x800080));
        pal.add(new Color(0x808000));
        pal.add(new Color(0x808080));

        int i;
        for (i = 0; i < 16; i++) {
            int v = Math.min(16 * i, 255);
            pal.add(new Color(v, v, v));
        }

        for (r = 0; r < 64; r += 9) {
            for (g = 0; g < 64; g += 9) {
                for (b = 0; b < 64; b += 21) {
                    pal.add(new Color(r, g, b));
                }
            }
        }

    }

    @Override
    public Iterable<Color> getPalette() {
        return pal;
    }
}
