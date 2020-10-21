package mayton.image;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RasterTest {
    
    @Test
    public void testRaster() {
        Raster r = new Raster(320,200);
        assertEquals(320, r.X);
        assertEquals(200, r.Y);
        
        Raster r2 = new Raster(r);
        assertEquals(320, r2.X);
        assertEquals(200, r2.Y);
        
        assertEquals(320, r.getWidth());
        assertEquals(200, r.getHeight());
    }
    
    @Test
    public void testSetPixelRGB() {
        Raster r = new Raster(320,200);
        r.setPixelRGB(0,0, 0x01, 0x23, 0x45);
        assertEquals(0x01, r.getRPixel(0, 0));
        assertEquals(0x23, r.getGPixel(0, 0));
        assertEquals(0x45, r.getBPixel(0, 0));
    }
   
    
    
    
    @Test
    public void getDistance_double() {
        int color1 = Raster.getPixel(255, 255, 255);
        int color2 = Raster.getPixel(255, 255, 255);
        assertEquals(0.0, Raster.getDistance(color1, color2), 0.001);
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

    @Disabled("I do not a reason!")
    @Test
    public void testGetVPixelDouble_double() {
        assertEquals(1.0,Raster.getVPixelDouble(0xFFFFFFFF),0.01);
        assertEquals(0.0,Raster.getVPixelDouble(0xFF000000),0.01);
    }


    @Test
    public void testGetPixel_3args() {
        assertEquals(0xFF000000, Raster.getPixel(0, 0, 0));
        assertEquals(0xFFFFFFFF, Raster.getPixel(255, 255, 255));
        assertEquals(0xFF0000FF, Raster.getPixel(Integer.MIN_VALUE, -1, Integer.MAX_VALUE));
    }
    
    @Test
    public void testGetPixel_4args() {
        assertEquals(0x80000000, Raster.getPixel(0, 0, 0, 0x80));
        assertEquals(0x80FFFFFF, Raster.getPixel(255, 255, 255, 0x80));
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

    }

    @Test
    public void testGetYPixel_int_int() {

    }

    @Test
    public void testGetYPixel_int() {
        assertEquals(0xFF, Raster.getYPixel(0x00FFFFFF));
    }

    @Test
    public void testGetRGBTextSignature() {
        assertEquals("(255,255,255)", Raster.getRGBTextSignature(0xFFFFFF));
        assertEquals("(0,0,0)", Raster.getRGBTextSignature(0x0));
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
    }

}