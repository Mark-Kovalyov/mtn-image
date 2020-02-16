package mayton.experimental;

import mayton.image.iterators.LinearPixIterator;
import mayton.image.standard.Resolutions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Bin2Png {

    public static void main(String[] args) throws Exception {
        String input = "/db/geo/GeoIPWhois/GeoIPCountryWhois.csv";
        File file = new File(input);
        if (file.length() > Integer.MAX_VALUE) {
            throw new Exception("Unable to process > 2G");
        }
        int length = (int) file.length();
        int width  = Resolutions.FULL_HD.x; //1 + (int) Math.sqrt(length);
        int height = Resolutions.FULL_HD.y; //length / width;
        InputStream is = new FileInputStream(file);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        byte[] res = is.readAllBytes();
        is.close();
        int i = 0;
        LinearPixIterator iterator = new LinearPixIterator(width, height);
        while (iterator.next()) {
            if (i + 3 >= res.length) {
                break;
            }
            int pixel = 0xFF000000 | ((res[i] << 16) | (res[i + 1] << 8) | res[i + 2]);
            int x = iterator.getX();
            int y = iterator.getY();
            bufferedImage.setRGB(x, y, pixel);
            //System.out.printf("%d %d %08X\n", x, y, pixel);
            i += 3;
        }
        ImageIO.write(bufferedImage, "PNG", new FileOutputStream(input + ".png"));
    }

}
