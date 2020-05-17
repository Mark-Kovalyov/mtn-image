package mayton.image.houghtransform;

import mayton.image.Raster;
import mayton.image.Rect;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.ThreadSafe;
import java.awt.image.BufferedImage;
import java.util.Properties;
import java.util.function.Function;

import static java.lang.Math.sin;
import static java.lang.Math.sqrt;


/**
 * Преобразование Хафа
 *
 * x = [0..π]
 * y = [-R..R]
 *
 * Уравнение прямой в полярных координатах
 *
 *
 */
@ThreadSafe
public class HoughAnalyzer implements Function<Pair<BufferedImage, Properties>, BufferedImage> {

    private static final double π = Math.PI;

    private double R = 0.0;

    /**
     * Draws sine function
     */
    public void dropSine(BufferedImage houghPlane, Rect sourceRect, int xx, int yy) {
        double ρ;
        double φ;
        double radius;
        int h = houghPlane.getHeight();
        int w = houghPlane.getWidth();
        for(int x = 0; x < w; x++) {
            int y = (int) (120 + 120.0 * sin(x / 200.0));
            houghPlane.setRGB(x, y, 0xFF_FFFFFF);
        }
    }

    public double detectRadius(Rect rect) {
        int height = rect.getHeight();
        int width = rect.getWidth();
        return sqrt((double) width * width + (double) height * height);
    }

    public int roundLineWithHoughFilling(int x, int y) {
        double θ = π / 32.0;
        for(double φ = 0.0; φ < π ; φ += θ) {

        }
        return 0;
    }

    /**
     *
     * @param bufferedImageRectPair
     * @return houghPlane
     */
    @Override
    public BufferedImage apply(@NotNull Pair<BufferedImage, Properties> bufferedImageRectPair) {
        BufferedImage image = bufferedImageRectPair.getLeft();
        Properties props = bufferedImageRectPair.getRight();
        // For parallel processing
        Rect inputRect = (Rect) props.get("inputRect");
        //ISize size = bufferedImageRectPair.getMiddle();
        int x1 = inputRect.x1;
        int y1 = inputRect.y1;
        int x2 = inputRect.x2;
        int y2 = inputRect.y2;

        Rect houghRect = (Rect) props.get("houghRect");

        BufferedImage houghPlane = new BufferedImage(houghRect.getWidth(), houghRect.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        R = detectRadius(houghRect);

        //
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                int color = image.getRGB(x, y);
                boolean isWhite = Raster.isPixelWhite(color);
                dropSine(houghPlane, inputRect, x, y);
            }
        }

        return houghPlane;
    }
}
