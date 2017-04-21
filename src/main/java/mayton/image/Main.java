package mayton.image;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static mayton.image.Raster.getYPixelDouble;

public class Main {

    public static void xorByStep(@Nonnull BufferedImage i, int dx, int dy,@Nonnull Rect r){
        int x1 = r.x1;
        int y1 = r.y1;
        int x2 = r.x2;
        int y2 = r.y2;
        for (int y = y1; y < y2; y+=dy) {
            for (int x = x1; x < x2; x+=dx) {
                int color = i.getRGB(x,y);
                if (color == 0xFFFFFFFF) {
                    i.setRGB(x,y,0x00000000);
                } else {
                    i.setRGB(x,y,0xFFFFFFFF);
                }
            }
        }
    }

    public static void xorByStep(@Nonnull BufferedImage i, int dx, int dy){
        xorByStep(i,dx,dy,new Rect(0,0,i.getWidth(),i.getHeight()));
    }

    public static void main(String[] args) throws IOException {
        int BORDER = 25;

        String root = "c:/pics/enc/";
        String inputFile  = "exolon.png";
        String outputFile = "exolon-enc.png";

        BufferedImage i = ImageIO.read(new FileInputStream(root + inputFile));
        int w = i.getWidth();
        int h = i.getHeight();
        BufferedImage i2 = new BufferedImage(w,h,BufferedImage.TYPE_BYTE_BINARY);

        Graphics2D g2d = i2.createGraphics();



        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int color = i.getRGB(x,y);
                double v = getYPixelDouble(color);
                if (v > 0.5) {
                    i2.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    i2.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        int[] p = new int[]{2,3,5,5,7,11,13,17,19,23,29,31,37,39};

        for (int k = 0; k < p.length; k++) {
            xorByStep(i2, p[k], 1, new Rect(0 + BORDER, 0 + BORDER, w - BORDER, h - BORDER));
            xorByStep(i2, 1, p[k], new Rect(0 + BORDER, 0 + BORDER, w - BORDER, h - BORDER));
        }

        /*g2d.setColor(Color.WHITE);
        g2d.setBackground(Color.WHITE);

        g2d.fillRect(0,0,BORDER,i.getHeight());
        g2d.fillRect(0,h - BORDER,w,i.getHeight());
        g2d.fillRect(w - BORDER, 0, w,i.getHeight());

        g2d.setColor(Color.BLACK);
        for (int k = 0; k < p.length; k++) {
            Rect r = new Rect(k * BORDER, 0, k * BORDER + BORDER, BORDER);
            g2d.fillOval(r.x1, r.y1, r.getWidth(), r.getHeight());
            xorByStep(i2, p[k], 1, r);
        }

        for (int k = 0; k < p.length; k++) {
            Rect r = new Rect(0, BORDER * k, BORDER, BORDER * k + BORDER);
            g2d.fillOval(r.x1, r.y1, r.getWidth(), r.getHeight());
            xorByStep(i2,  1, p[k], r);
        }*/

        ImageIO.write(i2,"PNG",new FileOutputStream(root + outputFile));
    }

}
