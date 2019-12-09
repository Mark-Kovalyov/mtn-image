/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image;

import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.concurrent.ThreadSafe;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author mayton
 */
@ThreadSafe
public abstract class GenericRasterFilter {

    public enum Mandatority {
        MANDATORY, OPTIONAL
    }

    @Contract(pure = true)
    @NotNull
    public abstract BufferedImage doFilter(@NotNull BufferedImage source, @Nullable Map<String, Object> parameters);

    @Contract(pure = true)
    @NotNull
    public Map<String, Pair<Class, Mandatority>> describeParameters() {
        return Collections.emptyMap();
    }

}
