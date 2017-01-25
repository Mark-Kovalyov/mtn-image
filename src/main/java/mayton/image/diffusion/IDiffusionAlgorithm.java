package mayton.image.diffusion;

import mayton.image.Raster;
import mayton.math.INumericMatrix;

import java.awt.Color;
import java.util.List;

public interface IDiffusionAlgorithm
{
    //public INumericMatrix process(Raster r);

    public Raster processRaster(Raster r);
}
