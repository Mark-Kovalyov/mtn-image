/**
 * Created by IntelliJ IDEA.
 * User: mayton
 * Date: 16.05.2007
 * Time: 18:59:23
 * To change this template use File | Settings | File Templates.
 */
package mayton.image.palettes;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * Стандартная палитра 16 цветов VGA
 * @author mayton
 */
public class VGA16Palette implements IPalette{

    private static VGA16Palette instance = new VGA16Palette();

    private static List<Color> pal;

    public static VGA16Palette getInstance() {
        return instance;
    }

    private VGA16Palette() {
        pal =new ArrayList<>();
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
    }

    @Override
    public Iterable<Color> getPalette()
    {
        return pal;
    }
}
