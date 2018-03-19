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

    int  getPixel(int x,int y);

    int  getWidth();

    int  getHeight();

}
