package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import mayton.image.Raster;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public class CanvasExtenderMirrorFilter extends GenericRasterFilter {

    static Logger logger = LoggerFactory.getLogger(CanvasExtenderMirrorFilter.class);

    @Override
    public @NotNull BufferedImage doFilter(@NotNull BufferedImage src, @Nullable Map<String, Object> parameters) {
        int bs = (Integer) parameters.get("borderSize");
        checkArgument(bs > 0);
        int x = src.getWidth();
        int y = src.getHeight();
        logger.trace(":: detect input image size : {} x {} and colorModel = {}", x, y, src.getColorModel());
        int xr = x + 2 * bs;
        int yr = y + 2 * bs;
        BufferedImage dest = new BufferedImage(xr, yr, BufferedImage.TYPE_INT_ARGB);
        Raster.copyImageIntoPos(src, dest, bs, bs);
        // Left + Right
        for (int i = 0; i < yr; i++) {
            int k = bs - 1;
            for (int j = bs; j < (bs + bs); j++) {
                dest.setRGB(k, i, dest.getRGB(j, i));
                k--;
            }
            k = bs + x - 1;
            for (int j = bs + x; j < xr; j++) {
                dest.setRGB(j, i, dest.getRGB(k, i));
                k--;
            }
        }
        // Top
        int k = bs - 1;
        for (int i = bs; i < (bs + bs); i++) {
            for (int j = bs; j < (xr - bs); j++) {
                dest.setRGB(j, k, dest.getRGB(j, i));
            }
            k--;
        }
        k = yr - bs - 1;
        for (int i = yr - bs; i < yr; i++) {
            for (int j = bs; j < (xr - bs); j++) {
                dest.setRGB(j, i, dest.getRGB(j, k));
            }
            k--;
        }
        return dest;
    }

    @Override
    public @NotNull Map<String, Pair<Class, Mandatority>> describeParameters() {
        Map<String, Pair<Class, GenericRasterFilter.Mandatority>> map = new HashMap<>();
        map.put("border", ImmutablePair.of(Integer.TYPE, Mandatority.MANDATORY));
        return map;
    }
}
