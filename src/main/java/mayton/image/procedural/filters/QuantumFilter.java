package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import mayton.image.Raster;
import mayton.image.iterators.LinearPixIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.Map;

public class QuantumFilter extends GenericRasterFilter {

    @Override
    public @NotNull BufferedImage doFilter(@NotNull BufferedImage source, @Nullable Map<String, Object> parameters) {
        BufferedImage dest = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        LinearPixIterator linearPixIterator = new LinearPixIterator(source.getWidth(), source.getHeight());
        while(linearPixIterator.next()) {
            int color = source.getRGB(linearPixIterator.getX(), linearPixIterator.getY());
            double brightness = Raster.getYPixelDouble(color);
            if (brightness < 0.25) {
                // TODO
            }
        }
        return dest;
    }
}
