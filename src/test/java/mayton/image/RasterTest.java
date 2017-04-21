package mayton.image;

import org.junit.Test;

import static org.junit.Assert.*;


public class RasterTest {

    public RasterTest() {

    }

    @Test
    public void getDistance_double() {
        int color1 = Raster.getPixel(255, 255, 255);
        int color2 = Raster.getPixel(255, 255, 255);
        //int color3=Raster.getPixel(0,0,0);
        assertEquals(0.0, Raster.getDistance(color1, color2), 0.001);
        //assertEquals(0.0,Raster.getDistance(color1, color3),0.001);

    }


    @Test
    public void testGetYPixelDouble_double() {

        assertEquals(1.0, Raster.getYPixelDouble(0xFFFFFFFF), 0.01);
        assertEquals(0.5, Raster.getYPixelDouble(Raster.getPixel(128, 128, 128)), 0.01);
        assertEquals(0.0, Raster.getYPixelDouble(0xFF000000), 0.01);

    }

    @Test
    public void testGetUPixelDouble_double() {

        int color = Raster.getPixelFromYUVDouble(0.0, 0.0, 0.0);
        assertEquals("YUV(0,0,0)", Raster.getYUVTextSignature(color));

    }

    @Test
    public void testGetVPixelDouble_double() {

        //assertEquals(1.0,Raster.getVPixelDouble(0xFFFFFFFF),0.01);
        //assertEquals(0.0,Raster.getVPixelDouble(0xFF000000),0.01);

    }


    @Test
    public void testGetPixel_3args() {

        //0xFF000000|R<<16|G<<8|B;
        assertEquals(0xFF000000, Raster.getPixel(0, 0, 0));
        assertEquals(0xFFFFFFFF, Raster.getPixel(255, 255, 255));
        assertEquals(0xFF0000FF, Raster.getPixel(Integer.MIN_VALUE, -1, Integer.MAX_VALUE));

    }


    @Test
    public void testGetGPixel_int() {

        assertEquals(0xFF, Raster.getGPixel(0x0000FF00));

    }


    @Test
    public void testGetBPixel_int() {

        assertEquals(0xFF, Raster.getBPixel(0x000000FF));

    }


    @Test
    public void testGetRPixel_int() {

        assertEquals(0xFF, Raster.getRPixel(0x00FF0000));

    }


    @Test
    public void testGetUPixel_int() {

        //fail("The Test case is a prototype.");
    }

    @Test
    public void testGetYPixel_int_int() {

        //fail("The Test case is a prototype.");
    }

    @Test
    public void testGetYPixel_int() {

        assertEquals(0xFF, Raster.getYPixel(0x00FFFFFF));

    }

    @Test
    public void testGetRGBTextSignature() {

        assertEquals("RGB(255,255,255)", Raster.getRGBTextSignature(0xFFFFFF));
        assertEquals("RGB(0,0,0)", Raster.getRGBTextSignature(0x0));


    }

    @Test
    public void testGetYUVTextSignature() {
        // Test BLACK

        int color = Raster.getPixelFromYUV(0, 0, 0);

        assertEquals("YUV(0,0,0)", Raster.getYUVTextSignature(color));


    }

    @Test
    public void testGetRGBTextSignatureHex() {

        assertEquals("FFFFFF", Raster.getRGBTextSignatureHex(0xFFFFFF));

    }

    @Test
    public void testGetPixelFromYUVDouble_int() {

    }


    @Test
    public void testGetPixelFromYUV_int() {

        assertEquals(0xFF000000, Raster.getPixelFromYUV(0, 0, 0));


        //int color1=Raster.getPixelFromYUV(254, -111, 0);
        //int color2=Raster.getPixelFromYUV(255, -112, 0);
        //int color3=Raster.getPixelFromYUV(256, -113, 0);

        //System.out.printf("color1 = %s , %s\n",Raster.getYUVTextSignature(color1),Raster.getRGBTextSignature(color1));
        //System.out.printf("color1 = %s , %s\n",Raster.getYUVTextSignature(color2),Raster.getRGBTextSignature(color2));
        //System.out.printf("color1 = %s , %s\n",Raster.getYUVTextSignature(color3),Raster.getRGBTextSignature(color3));


    }

}