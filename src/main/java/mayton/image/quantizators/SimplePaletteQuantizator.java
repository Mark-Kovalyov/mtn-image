package mayton.image.quantizators;

import mayton.image.Raster;
import mayton.image.iterators.RandomIterator;

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

public class SimplePaletteQuantizator implements IPaletteQuantizator {

    private static SimplePaletteQuantizator instance=new SimplePaletteQuantizator();

    private SimplePaletteQuantizator()
    {

    }

    public static SimplePaletteQuantizator getInstance()
    {
        return instance;
    }

    public List<Color> getPalette(Raster r,int n) {
        
        ArrayList<Color> al=new ArrayList<>(256);
        RandomIterator ri=new RandomIterator(r.X, r.Y);
        for(int i=0;i<256;i++)
        {
            ri.next();
            al.add(new Color(r.getPixel(ri.getX(),ri.getY())));
        }
        /*
        int k=0;
        for(int i=0;i<16;i++)
        {
            for(int j=0;j<16;j++)
            {
                i_col[k++]=r.getPixel((r.X*j)/16,(r.Y*i)/16);
            }
        }
        */

        return al;
    }

    


}
