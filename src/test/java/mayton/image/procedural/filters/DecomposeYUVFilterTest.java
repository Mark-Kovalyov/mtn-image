package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class DecomposeYUVFilterTest {

    @Test
    public void test() throws IOException {
        GenericRasterFilter canvasExtenderFilter = new DecomposeYUVFilter();
        Map<String, Object> map = new HashMap<>();
        map.put("showLegend", true);
        BufferedImage result = canvasExtenderFilter.doFilter(ImageIO.read(
                new FileInputStream(
                        "src/test/resources/rubens_850.jpg"
                )), null);


        assertNotNull(result);
        String tempDir = System.getProperty("java.io.tmpdir");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-ss-ss");

        ImageIO.write(result, "PNG",
                new FileOutputStream(tempDir +
                        "/decompose-yuv-filter-" +
                        (dateFormat.format(new Date()) + ".png")
                )
        );
    }

}
