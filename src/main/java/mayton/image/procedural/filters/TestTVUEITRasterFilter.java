/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import mayton.image.IImmutablePixelMatrix;
import mayton.image.Raster;

/**
 *
 * @author mayton
 */
public class TestTVUEITRasterFilter implements IImmutablePixelMatrix  {

    int X,Y;

    public TestTVUEITRasterFilter(int x,int y)
    {
        this.X=x;
        this.Y=y;
    }

    @Override
    public int getPixel(int x, int y) {
        int u=x/16;
        int v=y/16;
        if ((u%2==0)&&(v%2==0)) return Raster.getPixel(255, 0, 0);
        if ((u%2==0)&&(v%2==1)) return Raster.getPixel(0,255, 0);
        if ((u%2==1)&&(v%2==0)) return Raster.getPixel(0,0,255);
        return 0;
    }

    @Override
    public int getWidth() {
        return X;
    }

    @Override
    public int getHeight() {
        return Y;
    }

}
