package mayton.image.palettes;

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
public class WindowsPalette implements IPalette
{
    private static WindowsPalette ourInstance = new WindowsPalette();

    private static List<Color> Pal;

    private WindowsPalette()
    {
        Pal=new ArrayList<>();
        Pal.add(new Color(0x000000));
        Pal.add(new Color(0x0000FF));
        Pal.add(new Color(0x00FF00));
        Pal.add(new Color(0x00FFFF));

        Pal.add(new Color(0xFF0000));
        Pal.add(new Color(0xFF00FF));
        Pal.add(new Color(0xFFFF00));
        Pal.add(new Color(0xFFFFFF));

        Pal.add(new Color(0xC0C0C0));
        Pal.add(new Color(0x000080));
        Pal.add(new Color(0x008000));
        Pal.add(new Color(0x008080));

        Pal.add(new Color(0x800000));
        Pal.add(new Color(0x800080));
        Pal.add(new Color(0x808000));
        Pal.add(new Color(0x808080));


        Pal.add(new Color(0xC0DCC0));
        Pal.add(new Color(0xA6CAF0));
        Pal.add(new Color(0xFFFBF0));
        Pal.add(new Color(0xA0A0A4));


    }

    public static WindowsPalette getInstance() {

            return ourInstance;
    }

    public java.util.List<Color> getPalette() {
        
        return Pal;
    }

}
