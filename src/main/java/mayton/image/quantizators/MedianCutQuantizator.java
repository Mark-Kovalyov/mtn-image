package mayton.image.quantizators;

import mayton.image.Raster;

import java.awt.Color;
import java.util.List;


/**
 * The idea behind the median cut alogrithm is to use each of the color in the
 * synthesized look-up table to represent an equal number of pixels in the
 * original image. The algorithm subdivides the color space interatively into
 * smaller and smaller boxes.
 *
 * The algorithm starts with a box that encloses all the different color
 * values from the original image. The "size" of the box is given by the
 * minimum and maximum of each of the color coordinates that encloses the
 * box we look at. For splitting the box we have to decide on which "side"
 * we want to subivide the box. Therefore the points are sorted along the
 * longest dimension of the box. The partitioning into two halves is made
 * at the median point. Approximately equal numbers of points will fall at each
 * side of the cutting plane.
 *
 * This step is applied until K boxes are generated and K maybe the maximum
 * number of color entries in the available colormap. The according color to
 * each box is calculated by averaging the colors in each box.
 *
 * Variations in the algorithm could be made by changing the criterion
 * where to intersect the box.
 *
 * An alternative to sorting the color values form a minimum value to a
 * maximum value could be to look at the coordinate with the largest variance.
 * Another alternative could be to minimize the sum of variances for the two new boxes.
 *
 */

public class MedianCutQuantizator implements IPaletteQuantizator {

    public List<Color> getPalette(Raster r,int n) {
        return null;
    }

}
