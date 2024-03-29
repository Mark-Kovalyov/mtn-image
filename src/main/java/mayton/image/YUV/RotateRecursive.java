package mayton.image.YUV;

import mayton.image.Rect;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class RotateRecursive {


    public static void writeRot(@NotNull BufferedImage i1, @NotNull BufferedImage i2, @NotNull Rect rect) {
        int half = rect.getWidth()/2;
        long cnt = 0;
        long cntRead = 0;
        for (int y = rect.y1 ; y < rect.y2; y++) {
            for (int x = rect.x1; x < rect.x2; x++) {
                // Translate (x,y) => to center of coordinates
                int xget1 = x - half - rect.x1;
                int yget1 = y - half - rect.y1;
                int xget = yget1 ;
                int yget = -xget1 ;
                // Translate (+half,+half)
                xget += (half + rect.x1);
                yget += (half + rect.y1);
                int color = 0xFF00_00FF;
                if (xget >= 0 && xget < i1.getWidth() && yget >=0 && yget < i1.getHeight()) {
                    color = i1.getRGB(xget, yget);
                    cntRead++;
                }
                i2.setRGB(x,y,color);
            }
        }
    }


    public static void recurse(@NotNull BufferedImage src,@NotNull BufferedImage dest,@NotNull Rect rect) throws Exception{
        assert src.getHeight() == dest.getHeight();
        writeRot(src, dest, rect);
        int size = rect.getHeight();
        if (size > 2) {
            int half = size / 2;
            recurse(src, dest, Rect.createSquare(rect.x1,        rect.y1,        half));
            recurse(src, dest, Rect.createSquare(rect.x1 + half, rect.y1,        half));
            recurse(src, dest, Rect.createSquare(rect.x1 + half, rect.y1 + half, half));
            recurse(src, dest, Rect.createSquare(rect.x1       , rect.y1 + half, half));
        }
    }

    static String root = "";
    static String inputFile = "";
    static String outputFile = "";


    public static void main(String[] args) throws Exception {


        BufferedImage i1 = ImageIO.read(new FileInputStream(root + inputFile));

        int w = i1.getWidth();
        int h = i1.getHeight();

        BufferedImage i2 = new BufferedImage(i1.getWidth(), i1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        recurse(i1, i2, new Rect(0,0,256,256));
        ImageIO.write(i2, "PNG", new FileOutputStream(root + outputFile));

    }
}
