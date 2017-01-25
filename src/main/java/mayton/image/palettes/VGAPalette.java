package mayton.image.palettes;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class VGAPalette implements IPalette
{
    private static VGAPalette ourInstance = new VGAPalette();

    private static List<Color> Pal;

    public static VGAPalette getInstance() {
        return ourInstance;
    }

    private VGAPalette()
    {
        Pal=new ArrayList<Color>();

        int r, g, b;

        Pal.add(new Color(0x000000));
        Pal.add(new Color(0x0000FF));
        Pal.add(new Color(0x00FF00));
        Pal.add(new Color(0x00FFFF));

        Pal.add(new Color(0xFF0000));
        Pal.add(new Color(0xFF00FF));
        Pal.add(new Color(0xFFFF00));
        Pal.add(new Color(0xFFFFFF));

        Pal.add(new Color(0x000000));
        Pal.add(new Color(0x000080));
        Pal.add(new Color(0x008000));
        Pal.add(new Color(0x008080));

        Pal.add(new Color(0x800000));
        Pal.add(new Color(0x800080));
        Pal.add(new Color(0x808000));
        Pal.add(new Color(0x808080));

        int i;
        for(i=0;i<16;i++) {
            int v=Math.min(16*i,255);
            Pal.add(new Color(v,v,v));        
        }
        
        for (r=0; r<64; r+=9 ){
            for (g=0; g<64; g+=9 ){
                for (b=0; b<64; b+=21 )
                {
                    Pal.add(new Color(r,g,b));
                }
            }
        }
        
    }

    @Override
    public List<Color> getPalette()
    {
        return Pal;
    }
}
