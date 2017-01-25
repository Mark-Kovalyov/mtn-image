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

    private static List<Color> Pal;

    public static VGA16Palette getInstance() {
        return instance;
    }

    private VGA16Palette()
    {
        Pal=new ArrayList<Color>();
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
    }

    @Override
    public List<Color> getPalette()
    {
        return Pal;
    }
}
