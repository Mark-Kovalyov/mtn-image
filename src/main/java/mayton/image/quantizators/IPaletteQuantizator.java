package mayton.image.quantizators;

import mayton.image.Raster;

import java.util.List;
import java.awt.*;

public interface IPaletteQuantizator
{
    List<Color> getPalette(Raster r,int ncolors);
}
