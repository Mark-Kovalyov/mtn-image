package mayton.experimental;

import mayton.image.Rect;
import mayton.image.houghtransform.HoughAnalyzer;
import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class HoughAnalyzerMain {

    public static void drawTestImage() {
        BufferedImage i = new BufferedImage(512,512,BufferedImage.TYPE_INT_ARGB);
        //ImageIO.write(result, "PNG", new FileOutputStream("..../test-img.png")); // TODO: add with sensitive
    }

    public static void main(String[] args) throws IOException {
        HoughAnalyzer houghAnalyzer = new HoughAnalyzer();
        Rect inputRect = new Rect(0, 0, 128, 128);
        Rect houghRect = new Rect(0, 0, 512, 512);
        Properties properties = new Properties();
        properties.put("inputRect", inputRect);
        properties.put("houghRect", houghRect);
        BufferedImage result = houghAnalyzer.apply(
                ImmutablePair.of(
                        ImageIO.read(new FileInputStream("....../lena.ppm.png")), // TODO: add with sensitive
                        properties
                ));

        ImageIO.write(result, "PNG", new FileOutputStream(".../lena-hough.png")); // TODO: add with sensitive

    }

}
