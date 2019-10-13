package mayton.image.palettes;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Arrays;

public class CGA1Palette implements IPalette {
    @NotNull
    @Override
    public Iterable<Color> getPalette() {
        return Arrays.asList(
                Color.BLACK,
                new Color(0x00AAAA),
                new Color(0xAA00AA),
                new Color(0xAAAAAA)
        );
    }
}
