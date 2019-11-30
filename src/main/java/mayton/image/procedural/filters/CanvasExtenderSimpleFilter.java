package mayton.image.procedural.filters;



import mayton.image.GenericRasterFilter;
import mayton.image.Raster;
import mayton.image.Rect;
import mayton.math.IMatrix;
import mayton.math.MatrixGauss;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public class CanvasExtenderSimpleFilter extends GenericRasterFilter {

    @Override
    public BufferedImage doFilter(@NotNull BufferedImage src, @Nullable Map<String, Object> parameters) {
        int borderSize = (Integer) parameters.get("borderSize");
        checkArgument(borderSize > 0);
        int x = src.getWidth();
        int y = src.getHeight();
        int xr = x + 2 * borderSize;
        int yr = y + 2 * borderSize;
        BufferedImage dest = new BufferedImage(xr, yr, BufferedImage.TYPE_INT_ARGB);
        Raster.copyImageIntoPos(src, dest, borderSize, borderSize);
        for (int j = borderSize; j > 1; j--) {
            for (int i = 1; i < xr - 1; i++) {
                int pixel1 = dest.getRGB(j, i - 1);
                int pixel2 = dest.getRGB(j, i);
                int pixel3 = dest.getRGB(j, i + 1);
                int res = Raster.avgPixel(pixel1, pixel2, pixel3);
                dest.setRGB(j - 1, i, res);
            }
        }
        for (int j = borderSize + x - 1; j < xr - 1; j++) {
            for (int i = 1; i < xr - 1; i++) {
                int pixel1 = dest.getRGB(j, i - 1);
                int pixel2 = dest.getRGB(j, i);
                int pixel3 = dest.getRGB(j, i + 1);
                int res = Raster.avgPixel(pixel1, pixel2, pixel3);
                dest.setRGB(j + 1, i, res);
            }
        }


        // TODO: Implement all border directions
        return dest;
    }

}
