/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.procedural.textures;

import java.awt.Color;
import mayton.image.IImmutablePixelMatrix;
import mayton.image.IPixelMatrix;
import mayton.image.IRasterRGB;

/**
 *  <h3>Procedural_texture</h3>
 *  http://en.wikipedia.org/wiki/Procedural_texture
 *
 *  <h4></h4>
 *
 *  Copyrighted Pixar 1988
 *  From the RenderMan Companion p. 355
 *  Listing 16.19  Blue marble surface shader
 *  blue_marble(): a marble stone texture in shades of blue
 *  surface
 *
 *
 */
public class Marble implements IImmutablePixelMatrix {

    int X;
    int Y;
    double   Ks    = 0.4;
    double   Kd    = 0.6;
    double   Ka    = 0.1;
    double   roughness = 0.1;
    double   txtscale = 1.0;
    double   specularcolor = 1.0; // must be a Color type ?


    public Marble(int size)
    {
        assert(size>=16);
        X=size;
        Y=size;

        //point PP;            /* scaled point in shader space */
        float csp;           /* color spline parameter */
        //point Nf;            /* forward-facing normal */
        //point V;             /* for specular() */
        float pixelsize, twice, scale, weight, turbulence;

        /* Obtain a forward-facing normal for lighting calculations. */
        //Nf = faceforward( normalize(N), I);
        //V = normalize(-I);

        /*
    * Compute "turbulence" a la [PERLIN85]. Turbulence is a sum of
    * "noise" components with a "fractal" 1/f power spectrum. It gives the
    * visual impression of turbulent fluid flow (for example, as in the
    * formation of blue_marble from molten color splines!). Use the
    * surface element area in texture space to control the number of
    * noise components so that the frequency content is appropriate
    * to the scale. This prevents aliasing of the texture.
    */

        //PP = transform("shader", P) * txtscale;
        //pixelsize = sqrt(area(PP));
        //twice = 2 * pixelsize;
        turbulence = 0;
        //for (scale = 1; scale > twice; scale /= 2){
            //turbulence += scale * noise(PP/scale);
        //}

        /* Gradual fade out of highest-frequency component near limit */

       //if (scale > pixelsize) {
       ////    weight = (scale / pixelsize) - 1;
           //weight = clamp(weight, 0, 1);
           //turbulence += weight * scale * noise(PP/scale);
       //}

        /*
    * Magnify the upper part of the turbulence range 0.75:1
    * to fill the range 0:1 and use it as the parameter of
    * a color spline through various shades of blue.
    */

        //csp = clamp(4 * turbulence - 3, 0, 1);

        //Color c=new Color(0.25f,0.25f,0.25f);

        //Ci = color spline(csp,
        //color (0.25, 0.25, 0.35),      /* pale blue        */
       //color (0.25, 0.25, 0.35),  /* pale blue        */
       //color (0.20, 0.20, 0.30),  /* medium blue      */
       //color (0.20, 0.20, 0.30),  /* medium blue      */
       //color (0.20, 0.20, 0.30),  /* medium blue      */
       //color (0.25, 0.25, 0.35),  /* pale blue        */
       //color (0.25, 0.25, 0.35),  /* pale blue        */
       //color (0.15, 0.15, 0.26),  /* medium dark blue */
       //color (0.15, 0.15, 0.26),  /* medium dark blue */
       //color (0.10, 0.10, 0.20),  /* dark blue        */
       //color (0.10, 0.10, 0.20),  /* dark blue        */
       //color (0.25, 0.25, 0.35),  /* pale blue        */
       //color (0.10, 0.10, 0.20)   /* dark blue        */
       //);

          /* Multiply this color by the diffusely reflected light. */
   //Ci *= Ka*ambient() + Kd*diffuse(Nf);

   /* Adjust for opacity. */
   //Oi = Os;
   //Ci = Ci * Oi;

   /* Add in specular highlights. */
   //Ci += specularcolor * Ks * specular(Nf,V,roughness);



    }

    public int getPixel(int x, int y) {
        return 0;
    }

    public int getWidth() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getHeight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
