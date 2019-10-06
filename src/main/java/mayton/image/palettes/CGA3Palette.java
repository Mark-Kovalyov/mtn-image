package mayton.image.palettes;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Arrays;

public class CGA3Palette implements IPalette {
    @Nonnull
    @Override
    public Iterable<Color> getPalette() {
        return Arrays.asList(
                Color.BLACK,
                new Color(0xAA0000),
                new Color(0x00AAAA),
                new Color(0xAAAAAA)
        );
    }
}

