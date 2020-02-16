package mayton.image.procedural;

import mayton.math.IMatrix;
import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Map;

@ThreadSafe
public interface IProceduralTexture {

    /**
     * Generate texture
     *
     * @param size - size of texture usually square
     * @param parameters - In general various interpretation. Depends on algorithm.
     * @return
     */
    @NotNull IMatrix generate(int size, @NotNull Map<String, String> parameters);

}
