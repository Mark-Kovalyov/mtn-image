package mayton.math;

import mayton.image.iterators.IPixIterator;
import mayton.image.iterators.LinearPixIterator;
import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.ThreadSafe;
import java.awt.image.BufferedImage;

@ThreadSafe
public class ImageUtils {

    @NotNull public static IMatrix imageToMatrix(@NotNull BufferedImage image) {
        return new MatrixGeneric(0);
    }

    @NotNull public static BufferedImage matrixToGrayImage(@NotNull IMatrix matrix, boolean autoNormalize) {
        BufferedImage image = new BufferedImage(matrix.getX(), matrix.getY(), BufferedImage.TYPE_INT_ARGB);
        if (autoNormalize) {
            IPixIterator iterator = new LinearPixIterator(matrix.getX(), matrix.getY());
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;
            while(iterator.next()) {
                double v = matrix.get(iterator.getX(), iterator.getY());
                max = Math.max(v, max);
                min = Math.min(v, min);
            }
            double amplitude = max - min;
            iterator.reset();
            while(iterator.next()) {
                double v = matrix.get(iterator.getX(), iterator.getY());
                image.setRGB(iterator.getX(), iterator.getY(), (int) (((v - min) / amplitude) * 255.0));
            }
        } else {
            throw new RuntimeException("Not implement!");
        }
        return image;
    }
}
