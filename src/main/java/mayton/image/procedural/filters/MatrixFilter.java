package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.Map;

public class MatrixFilter extends GenericRasterFilter {

    @Override
    public @NotNull BufferedImage doFilter(@NotNull BufferedImage source, @Nullable Map<String, Object> parameters) {
        return new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
    }
}
