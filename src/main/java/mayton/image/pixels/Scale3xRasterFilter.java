/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.pixels;

import mayton.image.GenericRasterFilter;
import mayton.image.IImmutablePixelMatrix;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author mayton
 */
public class Scale3xRasterFilter extends GenericRasterFilter {

    @Override
    public BufferedImage doFilter(@NotNull BufferedImage source, @Nullable Map<String, Object> parameters) {
        return null;
    }

    @Override
    public @NotNull Map<String, Pair<Class, Mandatority>> describeParameters() {
        return Collections.emptyMap();
    }
}
