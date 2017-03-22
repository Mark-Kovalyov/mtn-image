package mayton.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void xorByStep(BufferedImage i, int dx, int dy){
        for (int y = 0; y < i.getHeight(); y+=dy) {
            for (int x = 0; x < i.getWidth(); x+=dx) {
                int color = i.getRGB(x,y);
                if (color == 0xFFFFFFFF) {
                    i.setRGB(x,y,0x00000000);
                } else {
                    i.setRGB(x,y,0xFFFFFFFF);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String root = "~/";
        BufferedImage i = ImageIO.read(new FileInputStream(root + "alice.png"));
        //BufferedImage i2 = new BufferedImage(i.getWidth(),i.getHeight(),BufferedImage.TYPE_INT_ARGB);
        BufferedImage i2 = new BufferedImage(i.getWidth(),i.getHeight(),BufferedImage.TYPE_BYTE_BINARY);

        for (int y = 0; y < i.getHeight(); y++) {
            for (int x = 0; x < i.getWidth(); x++) {
                int color = i.getRGB(x,y);
                double v = Raster.getYPixelDouble(color);
                //System.out.printf("(%08X ; %f) ; ",color, v);
                if (v > 0.5) {
                    i2.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    i2.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        int[] p = new int[]{2,3,5,7,11,13,17,19};



        for(int k=0;k<p.length;k++){
            xorByStep(i2,p[k],1);
            xorByStep(i2,1,p[k]);
        }

        ImageIO.write(i2,"PNG",new FileOutputStream(root + "alice2.png"));
    }

}
