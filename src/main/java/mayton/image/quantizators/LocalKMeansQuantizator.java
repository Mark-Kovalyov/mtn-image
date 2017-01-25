package mayton.image.quantizators;

import mayton.image.Raster;

import java.awt.Color;
import java.util.List;

/**
 * // Clusters - ..., Clasters.centers - ....
 *
 * K = NOldColors;
 * // 
 * Clusters.centers = GetRandomFromSet(I,k);
 * // 
 * foreach( pixel in Image )
 * {
 *       pixel.cluster = Clusters.getClosest( pixel.color );
 * }
 * // 
 * // T1, T2 - , iter -
 * iter = 0;
 * while( ( moves != 0 ) OR ( moves < T1 AND iter > T2 ) )
 * {
 *       moves = 0;
 *       // 
 *       foreach( cluster in Clusters )
 *       {
 *             colorSet = { pixel.color for pixels in I
 *                                           if( pixel.cluster = cluster ) };
 *             cluster.center = Average( colorSet );
 *       }
 *       foreach( pixel in I )
 *       {
 *             newcluster = Clusters.getClosest( pixel.color );
 *             if( newcluster != pixel.cluster )
 *            {
 *                   moves++;
 *                   pixel.cluster = newcluster;
 *             }
 *       }
 *       iter++;
 * }
 * foreach( pixel in I )
 * {
 *       pixel.color = Clusters[pixel.cluster].center;
 * }
 *
 *
 */

public class LocalKMeansQuantizator implements IPaletteQuantizator
{

    public List<Color> getPalette(Raster r,int n) {
        return null;
    }

}
