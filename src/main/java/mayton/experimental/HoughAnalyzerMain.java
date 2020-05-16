package mayton.experimental;

import mayton.image.houghtransform.HoughAnalyzer;
import mayton.math.IMatrix;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HoughAnalyzerMain {

    public static void main(String[] args) throws IOException {
        HoughAnalyzer houghAnalyzer = new HoughAnalyzer();
        BufferedImage result = houghAnalyzer.apply(
                ImmutablePair.of(
                        ImageIO.read(new FileInputStream("/documents/image-processing/Color.Images/lena.ppm.png")),
                        new Properties()
                ));
        

    }

}
