package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class FunctionalBlurFilter extends GenericRasterFilter {

    @Override
    public @NotNull BufferedImage doFilter(@NotNull BufferedImage source, @Nullable Map<String, Object> parameters) {
        return null;
    }

    @Override
    public @NotNull Map<String, Pair<Class, Mandatority>> describeParameters() {
        Map<String, Pair<Class, GenericRasterFilter.Mandatority>> map = new HashMap<>();
        map.put("border", ImmutablePair.of(Integer.TYPE, Mandatority.MANDATORY));
        map.put("internalGaussRatio", ImmutablePair.of(Integer.TYPE, Mandatority.MANDATORY));
        map.put("internalGaussRatio", ImmutablePair.of(Integer.TYPE, Mandatority.MANDATORY));
        return map;
    }
}
