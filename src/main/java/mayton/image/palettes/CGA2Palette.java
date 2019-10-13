package mayton.image.palettes;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Arrays;

public class CGA2Palette implements IPalette {
    @NotNull
    @Override
    public Iterable<Color> getPalette() {
        return Arrays.asList(
                Color.BLACK,
                new Color(0x00AA00),
                new Color(0xAA0000),
                new Color(0xAA5500)
        );
    }
}
