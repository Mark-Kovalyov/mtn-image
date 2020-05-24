package mayton.image.procedural.filters;

import mayton.image.GenericRasterFilter;
import org.junit.Ignore;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
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

public class CanvasExtenderSimpleFilterTest {

    @Test
    @Ignore
    public void test() throws IOException {
        GenericRasterFilter canvasExtenderFilter = new CanvasExtenderSimpleFilter();
        Map<String, Object> params = new HashMap<>();
        params.put("borderSize", 256);

        BufferedImage result = canvasExtenderFilter.doFilter(ImageIO.read(
                new FileInputStream(
                        "........." // TODO: add with sensitive
                )), params);


        assertNotNull(result);
        String tempDir = System.getProperty("java.io.tmpdir");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-ss-ss");

        ImageIO.write(result, "PNG",
                new FileOutputStream(tempDir +
                    "/crop-canvas-ext-filter-" +
                    (dateFormat.format(new Date()) + ".png")
                )
        );
    }



}
