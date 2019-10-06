package mayton.image.palettes;

import javax.annotation.Nonnull;
import java.awt.Color;

/**
 * Интерфейс палитры
 * @author mayton
 */
public interface IPalette {

    @Nonnull
    Iterable<Color> getPalette();

}
