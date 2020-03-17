package mayton.image.procedural.textures;

import mayton.image.IImmutablePixelMatrix;
import mayton.image.procedural.IProceduralTexture;
import mayton.math.IMatrix;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class NoiseGen implements IImmutablePixelMatrix, IProceduralTexture {
    @Override
    public int getPixel(int x, int y) {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public @NotNull IMatrix generate(int size, @NotNull Map<String, String> parameters) {
        return null;
    }
}
