package mayton.image.procedural.filters;
import mayton.image.GenericRasterFilter;
import mayton.image.Raster;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public class CanvasExtenderSimpleFilter extends GenericRasterFilter {

    static Logger logger = LoggerFactory.getLogger(CanvasExtenderSimpleFilter.class);

    @Override
    public BufferedImage doFilter(@NotNull BufferedImage src, @Nullable Map<String, Object> parameters) {
        int bs = (Integer) parameters.get("borderSize");
        checkArgument(bs > 0);
        int x = src.getWidth();
        int y = src.getHeight();
        logger.trace(":: detect input image size : {} x {} and colorModel = {}",x, y, src.getColorModel());
        int xr = x + 2 * bs;
        int yr = y + 2 * bs;
        BufferedImage dest = new BufferedImage(xr, yr, BufferedImage.TYPE_INT_ARGB);
        Raster.copyImageIntoPos(src, dest, bs, bs);
        // Left
        for (int j = bs; j > 0; j--) {
            for (int i = 1 + bs; i < yr - 1 - bs; i++) {
                int pixel1 = dest.getRGB(j, i - 1);
                int pixel2 = dest.getRGB(j, i);
                int pixel3 = dest.getRGB(j, i + 1);
                int res = Raster.avgPixel(pixel1, pixel2, pixel3);
                dest.setRGB(j - 1, i, res);
            }
        }

        // Right
        for (int j = bs + x - 1; j < xr - 1; j++) {
            for (int i = 1 + bs; i < yr - 1 - bs; i++) {
                int pixel1 = dest.getRGB(j, i - 1);
                int pixel2 = dest.getRGB(j, i);
                int pixel3 = dest.getRGB(j, i + 1);
                int res = Raster.avgPixel(pixel1, pixel2, pixel3);
                dest.setRGB(j + 1, i, res);
            }
        }

        // Top
        for (int i = bs; i > 0; i--) {
            for (int j = 1 + bs; j < xr - 1 - bs; j++) {
                int pixel1 = dest.getRGB(j - 1, i);
                int pixel2 = dest.getRGB(j,     i);
                int pixel3 = dest.getRGB(j + 1, i);
                int res = Raster.avgPixel(pixel1, pixel2, pixel3);
                dest.setRGB(j, i - 1, res);
            }
        }

        // Bottom
        for (int i = y + bs; i < yr; i++) {
            for (int j = 1 + bs; j < xr - 1 - bs; j++) {
                int pixel1 = dest.getRGB(j - 1, i - 1);
                int pixel2 = dest.getRGB(j,     i - 1);
                int pixel3 = dest.getRGB(j + 1, i - 1);
                int res = Raster.avgPixel(pixel1, pixel2, pixel3);
                dest.setRGB(j, i, res);
            }
        }


        // TODO: Implement all border directions
        return dest;
    }

    @Override
    public @NotNull Map<String, Pair<Class, Mandatority>> describeParameters() {
        // TODO:
        return Collections.emptyMap();
    }

}
