package mayton.image.palettes;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mayton
 * Date: 17.05.2007
 * Time: 1:14:10
 * To change this template use File | Settings | File Templates.
 */
public class WindowsPalette implements IPalette {
    private static WindowsPalette ourInstance = new WindowsPalette();

    private static List<Color> pal;

    private WindowsPalette() {
        pal = new ArrayList<>();
        pal.add(new Color(0x000000));
        pal.add(new Color(0x0000FF));
        pal.add(new Color(0x00FF00));
        pal.add(new Color(0x00FFFF));

        pal.add(new Color(0xFF0000));
        pal.add(new Color(0xFF00FF));
        pal.add(new Color(0xFFFF00));
        pal.add(new Color(0xFFFFFF));

        pal.add(new Color(0xC0C0C0));
        pal.add(new Color(0x000080));
        pal.add(new Color(0x008000));
        pal.add(new Color(0x008080));

        pal.add(new Color(0x800000));
        pal.add(new Color(0x800080));
        pal.add(new Color(0x808000));
        pal.add(new Color(0x808080));


        pal.add(new Color(0xC0DCC0));
        pal.add(new Color(0xA6CAF0));
        pal.add(new Color(0xFFFBF0));
        pal.add(new Color(0xA0A0A4));


    }

    public static WindowsPalette getInstance() {

        return ourInstance;
    }

    @NotNull
    public Iterable<Color> getPalette() {
        return pal;
    }

}
