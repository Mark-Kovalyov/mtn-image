package mayton.image.quantizators;

import mayton.image.Raster;

import java.awt.Color;
import java.util.List;

/**
 * The third method for quantization we like to introduce is an approach
 * that is konwn under the name octree quantization. The idea here is to
 * build a tree structure containing always a maximum of K different
 * colors. If a further color is to be added to the tree structure,
 * its color value has to be merged with the most likely one that is
 * already in the tree. The both values are substituted by their mean.
 *
 * The most important data structure are the nodes of the octree. Each
 * inner node of the octree contain a maximum of eight successors, the
 * leave nodes keep information for the color value (colorvalue), the
 * color index (colorindex), and a counter (colorcount) for the pixel
 * that are already mapped to a particular leave. Because each of the
 * red, green and blue value is between 0 and 255 the maximum depth
 * of the tree is eight. In level i Bit i of RGB is used as selector
 * for the successors.
 *
 * The octree is constructed during reading the image that is to be quantized.
 * Only that parts of the octree are created that are really needed.
 * Initially the first K values are represented exactly (in level eight).
 * When the number of leaves nodes (currentK) exceeds K, the tree has to
 * reduced. That would mean that leaves at the largest depth are substituted
 * by their predecessor:
 *
 *
 * children = 0
 * for successor[i=1..8] do
 * {
 *
 *  if successor[i] != NULL then
 *  {
 *    children = children + 1
 *    sum the colorvalues and colorcount
 *    successor[i] = NULL
 *  }
 * }
 * currentK = currentK - children + 1
 *
 * In the end the octree for the entire image is generated. The K leaves are
 * used as entries for the color look-up table. the representative color value
 * for a leave is computed as the mean value of the color value and the color
 * count. The color index is also stored in the octree. 
 *
 * The quantization of the image is performed in a second step. Again the
 * image has to be read. The color values of each pixel are used for
 * traversing the octree data structure. The search along a path
 * through the tree is finished when a leave node is reached.
 */



public class OcTreeQuantizator implements IPaletteQuantizator  {

    public List<Color> getPalette(Raster r,int n) {
        return null;
    }


}
