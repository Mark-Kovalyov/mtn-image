package mayton.image.houghtransform;

import mayton.image.Raster;
import mayton.image.Rect;
import mayton.math.IMatrix;
import mayton.math.ISize;
import mayton.math.Matrix;
import mayton.math.Utils;
import org.apache.commons.lang3.tuple.Pair;

import java.awt.image.BufferedImage;
import java.util.function.Function;

public class HoughAnalyzer implements Function<Pair<BufferedImage, ISize>, IMatrix> {

    @Override
    public IMatrix apply(Pair<BufferedImage, ISize> bufferedImageRectPair) {
        IMatrix matrix = new Matrix();
        BufferedImage image = bufferedImageRectPair.getLeft();
        ISize size = bufferedImageRectPair.getRight();
        int w = size.getX();
        int h = size.getY();
        for(int x = 0;x<w;x++) {
            for(int y = 0;y<h;y++) {
                int color = image.getRGB(x,y);
                boolean isWhite = Raster.isPixelWhite(color);

            }
        }

        return matrix;
    }
}
