package mayton.image.palettes;

import org.jetbrains.annotations.NotNull;
import java.awt.Color;

/**
 * Интерфейс палитры
 * @author mayton
 */
public interface IPalette {

    @NotNull
    Iterable<Color> getPalette();

}
