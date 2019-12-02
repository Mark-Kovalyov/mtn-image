package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import mayton.image.Raster;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

// See: http://www.imagemagick.org/Usage/crop/
//
public class CropFilter extends GenericRasterFilter {

    @Override
    public @NotNull BufferedImage doFilter(@NotNull BufferedImage src, @Nullable Map<String, Object> parameters) {
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;
        if (parameters.containsKey("top")) {
            top = (Integer) parameters.get("top");
            checkArgument(top >= 0);
        }
        if (parameters.containsKey("left")) {
            left = (Integer) parameters.get("left");
            checkArgument(left >= 0);
        }
        if (parameters.containsKey("bottom")) {
            bottom = (Integer) parameters.get("bottom");
            checkArgument(bottom >= 0);
        }
        if (parameters.containsKey("right")) {
            right = (Integer) parameters.get("right");
            checkArgument(right >= 0);
        }
        int x = src.getWidth();
        int y = src.getHeight();
        BufferedImage dest = new BufferedImage(x - left - right, y - top - bottom, BufferedImage.TYPE_INT_ARGB);
        // TODO: Complete
        //Raster.copyImageIntoPos(src, dest, bs, bs);
        return dest;
    }

    @Override
    public @NotNull Map<String, Pair<Class, GenericRasterFilter.Mandatority>> describeParameters() {
        Map<String, Pair<Class, GenericRasterFilter.Mandatority>> map = new HashMap<>();
        map.put("left", ImmutablePair.of(Integer.TYPE, Mandatority.OPTIONAL));
        map.put("top", ImmutablePair.of(Integer.TYPE, Mandatority.OPTIONAL));
        map.put("right", ImmutablePair.of(Integer.TYPE, Mandatority.OPTIONAL));
        map.put("bottom", ImmutablePair.of(Integer.TYPE, Mandatority.OPTIONAL));
        return map;
    }
}
