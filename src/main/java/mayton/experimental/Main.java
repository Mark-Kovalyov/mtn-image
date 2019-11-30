package mayton.experimental;

import mayton.image.iterators.GilbertPixelIterator;
import mayton.image.iterators.IPixIterator;
import mayton.image.iterators.LinearPixIterator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("sensitive.properties"));

        BufferedImage src = ImageIO.read(new FileInputStream(properties.getProperty("experimental.src")));

        if (src.getWidth() != src.getHeight()) {
            throw new IllegalStateException(String.format("Unable to process image with different dimensions %d x %d", src.getWidth(), src.getHeight()));
        }

        BufferedImage dest = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());

        int size = src.getWidth();

        IPixIterator iPixIterator = new GilbertPixelIterator(size);

        IPixIterator destIterator = new LinearPixIterator(size, size);

        while(iPixIterator.next()) {
            destIterator.next();
            int x = iPixIterator.getX();
            int y = iPixIterator.getY();
            int pixel = src.getRGB(x,y);
            dest.setRGB(destIterator.getX(), destIterator.getY(), pixel);
        }

        ImageIO.write(dest, properties.getProperty("experimental.dest.format"), new FileOutputStream(properties.getProperty("experimental.dest")));

    }

}
