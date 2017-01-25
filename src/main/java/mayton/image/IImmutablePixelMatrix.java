/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image;

/**
 * Immutable ARGB PixelMatrix
 * 
 */
public interface IImmutablePixelMatrix {

    public int  getPixel(int x,int y);

    public int  getWidth();

    public int  getHeight();

}
