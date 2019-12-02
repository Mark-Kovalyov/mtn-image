package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Map;

public class NopFilter extends GenericRasterFilter {

    @Override
    public @NotNull BufferedImage doFilter(@NotNull BufferedImage source, @Nullable Map<String, Object> parameters) {
        // TODO: make copy
        return source;
    }

    @Override
    public @NotNull Map<String, Pair<Class, Mandatority>> describeParameters() {
        return Collections.emptyMap();
    }
}
