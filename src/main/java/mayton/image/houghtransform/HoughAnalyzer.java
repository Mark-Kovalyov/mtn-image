package mayton.image.houghtransform;

import mayton.image.Raster;
import mayton.math.IMatrix;
import mayton.math.ISize;
import mayton.math.Matrix;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.awt.image.BufferedImage;
import java.util.Properties;
import java.util.function.Function;

/**
 * Преобразование Хафа
 *
 * x = [0..π]
 * y = [0..R]
 *
 * Уравнение прямой
 *
 *
 */
public class HoughAnalyzer implements Function<Pair<BufferedImage, Properties>, BufferedImage> {

    private static final double π = Math.PI;

    public int roundLineWithHoughFilling(int x, int y) {
        double θ = π / 32.0;
        for(double φ = 0.0; φ < π ; φ += θ) {

        }
        return 0;
    }

    @Override
    public BufferedImage apply(Pair<BufferedImage, Properties> bufferedImageRectPair) {
        IMatrix matrix = new Matrix();
        BufferedImage image = bufferedImageRectPair.getLeft();
        BufferedImage out = new BufferedImage(512, 512, BufferedImage.TYPE_BYTE_GRAY);
        Properties props = bufferedImageRectPair.getRight();

        //ISize size = bufferedImageRectPair.getMiddle();
        int w = image.getWidth();
        int h = image.getHeight();

        //
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int color = image.getRGB(x, y);
                boolean isWhite = Raster.isPixelWhite(color);
                roundLineWithHoughFilling(x, y);
            }
        }

        return out;
    }
}
