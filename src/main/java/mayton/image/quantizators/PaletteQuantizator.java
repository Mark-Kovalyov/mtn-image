package mayton.image.quantizators;

import mayton.image.Raster;

import java.awt.Color;
import java.util.List;

public class PaletteQuantizator implements IPaletteQuantizator{

    public java.util.List<Color> getPalette() {
        return null;
    }

    public static int getIndex(int color,List<Color> Palette)
    {
        //System.out.printf(".detected %08X\n",color);
        int n=0;
        int n_min=0;
        double dist_min=Double.MAX_VALUE;
        while(n<Palette.size())
        {
            double temp_min= Raster.getDistance(color,Palette.get(n).getRGB());
            if (temp_min<dist_min)
            {
                //System.out.printf("..tracking distance = %f\n",temp_min);
                n_min=n;
                dist_min=temp_min;
            }
            n++;
        }
        //System.out.printf(".nearest color detected = %s\n",);
        return n_min;
    }

    public List<Color> getPalette(Raster r,int n) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
