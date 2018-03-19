package mayton.image.palettes;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * Палитра 256 градаций серого цвета
 * @author mayton
 */
public class GrayScalePalette implements IPalette{

    private static GrayScalePalette ourInstance = new GrayScalePalette();

    private static List<Color> Pal;

    public static GrayScalePalette getInstance() {
        return ourInstance;
    }

    private GrayScalePalette()
    {
        Pal=new ArrayList<>();
        for(int i=0;i<256;i++) Pal.add(new Color(i,i,i));
    }

    @Override
    public java.util.List<Color> getPalette() {
        return Pal;
    }
}
