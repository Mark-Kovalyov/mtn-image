package mayton.image.houghtransform;

import mayton.image.Raster;
import mayton.math.IMatrix;
import mayton.math.ISize;
import mayton.math.Matrix;
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
 *
 */
public class HoughAnalyzer implements Function<Triple<BufferedImage, ISize, Properties>, IMatrix> {

    private static final double π = Math.PI;

    public int roundLineWithHoughFilling(int x, int y) {
        double θ = π / 32.0;
        for(double φ = 0.0; φ < π ; φ += θ) {

        }
        return 0;
    }

    @Override
    public IMatrix apply(Triple<BufferedImage, ISize, Properties> bufferedImageRectPair) {
        IMatrix matrix = new Matrix();
        Properties props = bufferedImageRectPair.getRight();
        BufferedImage image = bufferedImageRectPair.getLeft();
        ISize size = bufferedImageRectPair.getMiddle();
        int w = size.getX();
        int h = size.getY();

        //
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int color = image.getRGB(x, y);
                boolean isWhite = Raster.isPixelWhite(color);
                roundLineWithHoughFilling(x, y);
            }
        }

        return matrix;
    }
}
