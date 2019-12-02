package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;

import static mayton.image.Raster.*;
import static mayton.image.Raster.getPixel;

public class DecomposeYUVFilter extends GenericRasterFilter {

    @Override
    public @NotNull BufferedImage doFilter(@NotNull BufferedImage source, @Nullable Map<String, Object> parameters) {
        int w = source.getWidth();
        int h = source.getHeight();
        BufferedImage dest = new BufferedImage(w * 2, h * 2, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int color = source.getRGB(x,y);
                int yv = (int)(255.0 * getYPixelDouble(color));
                int uv = (int)(255.0 * getUPixelDouble(color));
                int vv = (int)(255.0 * getVPixelDouble(color));
                dest.setRGB(x,     y,     color);
                dest.setRGB(x + w, y,     getPixel(yv,yv,yv));
                dest.setRGB(x,     y + h, getPixel(uv,uv,uv));
                dest.setRGB(x + w, y + h, getPixel(vv,vv,vv));
            }
        }
        if (parameters != null) {
            if (parameters.containsKey("showLegend")) {
                String text = "RGB";
                Graphics2D graphics = dest.createGraphics();
                // Get the FontMetrics
                Rectangle rect = new Rectangle(320,200,160,80);
                Font font = new Font("Arial", Font.PLAIN, 24);
                FontMetrics metrics = graphics.getFontMetrics();
                // Determine the X coordinate for the text
                int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
                // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
                int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
                // Set the font
                graphics.setFont(font);
                // Draw the String
                graphics.drawString(text, x, y);
            }
        }
        return dest;
    }

    @Override
    public @NotNull Map<String, Pair<Class, Mandatority>> describeParameters() {
        return null;
    }
}
