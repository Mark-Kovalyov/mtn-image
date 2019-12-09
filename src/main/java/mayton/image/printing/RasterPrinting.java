package mayton.image.printing;

import mayton.image.Raster;
import mayton.image.Rect;
import mayton.image.iterators.LinearPixIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class RasterPrinting {

    private static RasterPrinting instance = null;

    static Logger logger = LoggerFactory.getLogger(RasterPrinting.class);

    private static BufferedImage fontImage;

    private static Rect fontMetrics = new Rect(0, 0, 9, 16);

    private static Rect fontOffset = new Rect(7, 8, Integer.MAX_VALUE, Integer.MAX_VALUE);

    public static RasterPrinting createInstance() {
        if (instance == null) {
            instance = new RasterPrinting();
        }
        return instance;
    }

    private BufferedImage colorize(BufferedImage image) {
        BufferedImage dest = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = (Graphics2D) dest.getGraphics();
        AffineTransform transform = AffineTransform.getTranslateInstance(0.0, 0.0);
        graphics2D.drawImage(image, transform, null);
        return dest;
    }

    private RasterPrinting() {
        try {
            //InputStream inputStream = getClass().getResource("ms-dos-system-font.png").openStream();
            InputStream inputStream = new FileInputStream("src/main/resources/ms-dos-system-font.png");
            fontImage = colorize(ImageIO.read(inputStream));
            int w = fontImage.getWidth();
            int h = fontImage.getHeight();
            LinearPixIterator linearPixIterator = new LinearPixIterator(fontImage.getWidth(), fontImage.getHeight());
            Map<Integer, Integer> map = new HashMap<>();
            while(linearPixIterator.next()) {
                int x = linearPixIterator.getX();
                int y = linearPixIterator.getY();
                int color = fontImage.getRGB(x, y);
                if (color == 0xFF000000) {
                    fontImage.setRGB(x,y,0xFF_000000);
                } else {
                    fontImage.setRGB(x,y,0xFF_FFFFFF);
                }
                map.put(color, 1);
            }
            map.entrySet().forEach( x -> logger.info(format("COLOR[%08X] = %08X", x.getKey(), x.getValue())));
            Graphics2D graphics2D = (Graphics2D) fontImage.getGraphics();
            graphics2D.setColor(Color.GREEN);

            for(int x = fontOffset.x1 ; x < w ; x += fontMetrics.getWidth()) {
                graphics2D.drawLine(x, 0, x, h);
            }

            for(int y = fontOffset.y1 ; y < h ; y += fontMetrics.getHeight()) {
                graphics2D.drawLine(0, y, w, y);
            }


        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    public void print(@NotNull BufferedImage image, int row, int column, @Nullable String text, int color) {
        if (text != null) {
            Rect rect = new Rect(
                    fontOffset.x1 + fontMetrics.getWidth() * column,
                    fontOffset.y1 + fontMetrics.getHeight() * row,
                    fontOffset.x1 + fontMetrics.getWidth() * (column + 1),
                    fontOffset.y1 + fontMetrics.getHeight() * (row + 1)
            );

            //Raster.copyRectImageIntoPos(image, @NotNull Rect rect, @NotNull BufferedImage dest, int xpos, int ypos
        }
    }

}
