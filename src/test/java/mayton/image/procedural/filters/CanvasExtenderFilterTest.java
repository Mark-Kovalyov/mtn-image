package mayton.image.procedural.filters;

import mayton.image.standard.Resolutions;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CanvasExtenderFilterTest {

    @Test
    public void test() throws IOException {
        CanvasExtenderSimpleFilter canvasExtenderFilter = new CanvasExtenderSimpleFilter();
        Map<String, Object> params = new HashMap<>();
        params.put("borderSize", 128);
        BufferedImage result = canvasExtenderFilter.doFilter(ImageIO.read(
                new FileInputStream("src/test/resources/Mona-Lisa-crop-512x512.png")), params);


        assertNotNull(result);
        assertEquals(512 + 2 * 128, result.getWidth());
        assertEquals(512 + 2 * 128, result.getHeight());
        String tempDir = System.getProperty("java.io.tmpdir");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-ss-ss");

        ImageIO.write(result, "PNG", new FileOutputStream(tempDir + "/Mona-Lisa-crop-canvas-ext-filter-" + (
                dateFormat.format(new Date()) + ".png")));
    }

    @Test
    public void test2() {
        for(Resolutions res : Resolutions.values()) {
            System.out.printf("%s = (%d,%d) : ratio = %s\n", res.name(), res.x, res.y, res.ratio);
        }
    }

}
