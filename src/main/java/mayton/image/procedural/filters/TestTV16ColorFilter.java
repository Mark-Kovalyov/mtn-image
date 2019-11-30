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
public class TestTV16ColorFilter implements IImmutablePixelMatrix  {

    int X;
    int Y;


    public TestTV16ColorFilter()
    {
        X=768;
        Y=576;
    }

    public TestTV16ColorFilter(int x,int y)
    {
        assert(x>=0);
        assert(y>=0);
        X=x;
        Y=y;
    }

    @Override
    public int getPixel(int x, int y) {
        int bandWidth=X/8;
        if (x<bandWidth)   return 0xFFFFFF;
        if (x<2*bandWidth) return 0xFFFF00;
        if (x<3*bandWidth) return 0x00FFFF;
        if (x<4*bandWidth) return 0x00FF00;
        if (x<5*bandWidth) return 0xFF00FF;
        if (x<6*bandWidth) return 0xFF0000;
        if (x<7*bandWidth) return 0x0000FF;
        return 0x000000;
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
