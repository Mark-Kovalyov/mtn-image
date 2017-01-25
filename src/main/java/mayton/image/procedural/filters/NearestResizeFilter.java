/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import mayton.image.IImmutablePixelMatrix;

/**
 *
 * @author mayton
 */
public class NearestResizeFilter extends GenericRasterFilter implements IImmutablePixelMatrix {

    double scaleFactor;
    int X;
    int Y;
    int scaleAlgorithm;  // {-1,0,1}
    IImmutablePixelMatrix source;

    /**
     * 
     * @param source
     * @param scaleFactor множитель. Большее значение соответствуюет увеличению
     */
    public NearestResizeFilter(IImmutablePixelMatrix source,double scaleFactor)
    {
        assert(scaleFactor>=1.0);
        assert(scaleFactor<=64.0);
        assert(source!=null);
        X=(int)(source.getWidth()*scaleFactor);
        Y=(int)(source.getHeight()*scaleFactor);
        this.source=source;
        this.scaleFactor=scaleFactor;
    }

    @Override
    public int getPixel(int x, int y)
    {
        if (x<0) x=0;
        if (y<0) y=0;
        if (x>=X) x=X-1;
        if (y>=Y) y=Y-1;
        return source.getPixel((int)(x/scaleFactor), (int)(y/scaleFactor));
    }

    @Override
    public int getWidth()
    {
        return X;
    }

    @Override
    public int getHeight()
    {
        return Y;
    }

    @Override
    public int getProgress() {
        return 100;
    }

    @Override
    public boolean isCached() {
        return false;
    }

}
