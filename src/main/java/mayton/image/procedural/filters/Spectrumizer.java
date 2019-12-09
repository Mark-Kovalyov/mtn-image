package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import mayton.image.iterators.LinearPixIterator;
import mayton.image.standard.Resolutions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.image.BufferedImage;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public class Spectrumizer extends GenericRasterFilter {

    static final int WIDTH = Resolutions.SINCLAIR.x;
    static final int HEIGHT = Resolutions.SINCLAIR.y;

    @Override
    public @NotNull BufferedImage doFilter(@NotNull BufferedImage source, @Nullable Map<String, Object> parameters) {
        checkArgument(source.getWidth() == WIDTH);
        checkArgument(source.getHeight() == HEIGHT);
        BufferedImage result = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_BYTE_INDEXED);
        int col = 0;
        int row = 0;

        LinearPixIterator cursorIterator = new LinearPixIterator(WIDTH / 8, HEIGHT * 8);
        while(cursorIterator.next()) {
            // Detect optimal palette
            LinearPixIterator linearPixIterator = new LinearPixIterator(col * 8, row * 8);
            while(linearPixIterator.next()) {
                
            }
        }

        return result;
    }

}
