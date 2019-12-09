package mayton.image.printing;

import org.apache.log4j.PropertyConfigurator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure("log4j.properties");
        String tempDir = System.getProperty("java.io.tmpdir");
        RasterPrinting rasterPrinting = RasterPrinting.createInstance();
        BufferedImage image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_ARGB);
        //Graphics2D graphics2D = (Graphics2D) out.getGraphics();
        rasterPrinting.print(image, 0, 0, "Hello world", 0xFF_FFFFFF);
        ImageIO.write(image, "PNG", new FileOutputStream(tempDir + "/raster-printing.png"));
    }
}
