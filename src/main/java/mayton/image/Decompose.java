package mayton.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static mayton.image.Raster.*;

public class Decompose {

    public static void main(String[] args) throws IOException {

        String root = System.getProperty("user.home") + "/.decompose/";
        String inputFile  = "printer.jpg";
        String outputFile = inputFile + "-enc.png";

        BufferedImage i = ImageIO.read(new FileInputStream(root + inputFile));
        int w = i.getWidth();
        int h = i.getHeight();
        BufferedImage i2 = new BufferedImage(w * 2,h * 2,BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int color = i.getRGB(x,y);
                int yv = (int)(255.0 * getYPixelDouble(color));
                int uv = (int)(255.0 * getUPixelDouble(color));
                int vv = (int)(255.0 * getVPixelDouble(color));
                i2.setRGB(x,y,getPixel(yv,yv,yv));
                i2.setRGB(x + w,y,getPixel(uv,uv,uv));
                i2.setRGB(x ,y + h,getPixel(vv,vv,vv));
            }
        }

        ImageIO.write(i2,"PNG",new FileOutputStream(root + outputFile));
    }


}
