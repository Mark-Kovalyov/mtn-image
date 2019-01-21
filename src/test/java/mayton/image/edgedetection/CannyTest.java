package mayton.image.edgedetection;

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CannyTest {

    @Test
    public void apply() {
        Function<BufferedImage, BufferedImage> function = new Canny();
        BufferedImage image = new BufferedImage(320,200,BufferedImage.TYPE_INT_ARGB);
        assertNotNull(function.apply(image));
    }
}