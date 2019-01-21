package mayton.image.edgedetection;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.function.Function;

public class Canny implements Function<BufferedImage, BufferedImage> {


    /**
     *     1) Apply Gaussian filter to smooth the image in order to remove the noise
     *
     *     2) Find the intensity gradients of the image
     *
     *     3) Apply non-maximum suppression to get rid of spurious response to edge detection
     *
     *     4) Apply double threshold to determine potential edges
     *
     *     5) Track edge by hysteresis: Finalize the detection of edges by suppressing all
     *     the other edges that are weak and not connected to strong edges.
     *
     * @param bufferedImage
     * @return
     */
    @Override
    public BufferedImage apply(BufferedImage bufferedImage) {
        // TODO: Implement
        ColorModel cm = bufferedImage.getColorModel();

        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bufferedImage.copyData(null);
        BufferedImage image = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        return image;
    }
}
