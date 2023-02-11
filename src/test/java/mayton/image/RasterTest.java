package mayton.image;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RasterTest {

    private static File tmpDir = new File("/tmp/mtn-image");

    public static Triple<Integer,Integer,Integer> fromYUVtoRGB(double r, double g, double b) {
        return Triple.of(0,0,0);
    }

    @Test
    void testHSV() {
        double EPSILON = 0.01;
        int redColor = Raster.getPixelFromHSVDouble(0.0, 1.0, 1.0);

        double r = Raster.getRPixel(redColor) / 255.0;
        double g = Raster.getGPixel(redColor) / 255.0;
        double b = Raster.getBPixel(redColor) / 255.0;

        assertEquals(1.0, r, EPSILON);
        assertEquals(0.0, g, EPSILON);
        assertEquals(0.0, b, EPSILON);

        int yellowColor = Raster.getPixelFromHSVDouble(0.0 + 1.0 / 6.0, 1.0, 1.0);
        r = Raster.getRPixel(yellowColor) / 255.0;
        g = Raster.getGPixel(yellowColor) / 255.0;
        b = Raster.getBPixel(yellowColor) / 255.0;

        assertEquals(1.0, r, EPSILON);
        assertEquals(1.0, g, EPSILON);
        assertEquals(0.0, b, EPSILON);

    }

    @Test
    @Tag("file")
     void compVisionScrambler() throws IOException {
        BufferedImage src = ImageIO.read(new FileInputStream("src/main/resources/Nature_30.jpg"));
        int W = src.getWidth();
        int H = src.getHeight();
        BufferedImage bufferedImage = new BufferedImage(3 * W, 2 * H, BufferedImage.TYPE_INT_RGB);
         for (int y = 0; y < H ; y++) {
             for (int x = 0; x < W; x++) {
                 // Исходный RGB
                 int rgb = src.getRGB(x, y);
                 // Ребалансированный с подавлением

                 // Проверка канала яркости
                 double brightness = Raster.getYPixelDouble(rgb);
                 int scrambled = Raster.getPixelFromHSVDouble(brightness, 1.0, 1.0);
                 bufferedImage.setRGB(x, y, rgb);
                 bufferedImage.setRGB(x + W, y, Raster.getPixel(brightness, brightness, brightness));
                 bufferedImage.setRGB(x + 2 * W, y, scrambled);


             }
         }
        tmpDir.mkdirs();
        File tempFile = File.createTempFile("compVisionScrambler-", ".png", tmpDir);
        ImageIO.write(bufferedImage, "PNG", new FileOutputStream(tempFile));
    }

    @Test
    @Tag("file")
    void test() throws IOException {
        tmpDir.mkdirs();
        File tempFile = File.createTempFile("TestHSV-", ".png", tmpDir);
        int W = 800;
        int H = 600;
        BufferedImage bufferedImage = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < H / 2; y++) {
            for (int x = 0; x < W; x++) {
                double h = (double) x / W;
                double s = (double) y / (H / 2);
                double v = 1.0;
                int pixel = Raster.getPixelFromHSVDouble(h, s, v);
                bufferedImage.setRGB(x, y, pixel);
            }
        }
        for (int y = 0; y < H / 2; y++) {
            for (int x = 0; x < W; x++) {
                double h = (double) x / W;
                double s = 1.0;
                double v = 1.0 - (double) y / (H / 2);
                int pixel = Raster.getPixelFromHSVDouble(h, s, v);
                bufferedImage.setRGB(x, y + H / 2, pixel);
            }
        }
        ImageIO.write(bufferedImage, "PNG", new FileOutputStream(tempFile));
        System.out.printf("tempFile = %s\n", tempFile.getAbsolutePath());
    }
    
    @Test
    void testRaster() {
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
    void testSetPixelRGB() {
        Raster r = new Raster(320,200);
        r.setPixelRGB(0,0, 0x01, 0x23, 0x45);
        assertEquals(0x01, r.getRPixel(0, 0));
        assertEquals(0x23, r.getGPixel(0, 0));
        assertEquals(0x45, r.getBPixel(0, 0));
    }
   
    
    
    
    @Test
    void getDistance_double() {
        int color1 = Raster.getPixel(255, 255, 255);
        int color2 = Raster.getPixel(255, 255, 255);
        assertEquals(0.0, Raster.getDistance(color1, color2), 0.001);
    }


    @Test
    void testGetYPixelDouble_double() {
        assertEquals(1.0, Raster.getYPixelDouble(0xFFFFFFFF), 0.01);
        assertEquals(0.5, Raster.getYPixelDouble(Raster.getPixel(128, 128, 128)), 0.01);
        assertEquals(0.0, Raster.getYPixelDouble(0xFF000000), 0.01);
    }

    @Test
    void testGetUPixelDouble_double() {
        int color = Raster.getPixelFromYUVDouble(0.0, 0.0, 0.0);
        assertEquals("YUV(0,0,0)", Raster.getYUVTextSignature(color));
    }

    @Disabled()
    @Test
    void testGetVPixelDouble_double() {
        assertEquals(1.0,Raster.getVPixelDouble(0xFFFFFFFF),0.01);
        assertEquals(0.0,Raster.getVPixelDouble(0xFF000000),0.01);
    }


    @Test
    void testGetPixel_3args() {
        assertEquals(0xFF000000, Raster.getPixel(0, 0, 0));
        assertEquals(0xFFFFFFFF, Raster.getPixel(255, 255, 255));
        assertEquals(0xFF0000FF, Raster.getPixel(Integer.MIN_VALUE, -1, Integer.MAX_VALUE));
    }
    
    @Test
    void testGetPixel_4args() {
        assertEquals(0x80000000, Raster.getPixel(0, 0, 0, 0x80));
        assertEquals(0x80FFFFFF, Raster.getPixel(255, 255, 255, 0x80));
    }


    @Test
    void testGetGPixel_int() {
        assertEquals(0xFF, Raster.getGPixel(0x0000FF00));
    }


    @Test
    void testGetBPixel_int() {
        assertEquals(0xFF, Raster.getBPixel(0x000000FF));
    }


    @Test
    void testGetRPixel_int() {
        assertEquals(0xFF, Raster.getRPixel(0x00FF0000));
    }


    @Test
    void testGetUPixel_int() {

    }

    @Test
    void testGetYPixel_int_int() {

    }

    @Test
    void testGetYPixel_int() {
        assertEquals(0xFF, Raster.getYPixel(0x00FFFFFF));
    }

    @Test
    void testGetRGBTextSignature() {
        assertEquals("(255,255,255)", Raster.getRGBTextSignature(0xFFFFFF));
        assertEquals("(0,0,0)", Raster.getRGBTextSignature(0x0));
    }

    @Test
    void testGetYUVTextSignature() {
        // Test BLACK
        int color = Raster.getPixelFromYUV(0, 0, 0);
        assertEquals("YUV(0,0,0)", Raster.getYUVTextSignature(color));
    }

    @Test
    void testGetRGBTextSignatureHex() {
        assertEquals("FFFFFF", Raster.getRGBTextSignatureHex(0xFFFFFF));
    }

    @Test
    void testGetPixelFromYUVDouble_int() {

    }


    @Test
    void testGetPixelFromYUV_int() {
        assertEquals(0xFF000000, Raster.getPixelFromYUV(0, 0, 0));
    }

}