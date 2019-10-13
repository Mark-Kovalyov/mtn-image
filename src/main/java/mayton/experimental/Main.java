package mayton.experimental;

import mayton.image.iterators.GilbertPixelIterator;
import mayton.image.iterators.IPixIterator;
import mayton.image.iterators.LinearPixIterator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedImage src = ImageIO.read(new FileInputStream("/storage/pics/Da-Vinchi/Mona-Lisa-crop-256x256-bw.png"));

        BufferedImage dest = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());

        IPixIterator iPixIterator = new GilbertPixelIterator(256);

        IPixIterator destIterator = new LinearPixIterator(256, 256);

        while(iPixIterator.next()) {
            destIterator.next();
            int x = iPixIterator.getX();
            int y = iPixIterator.getY();
            int pixel = src.getRGB(x,y);
            dest.setRGB(destIterator.getX(), destIterator.getY(), pixel);
        }

        ImageIO.write(dest, "PNG", new FileOutputStream("/storage/pics/Da-Vinchi/Mona-Lisa-crop-256x256-bw-out.png"));

    }

}
