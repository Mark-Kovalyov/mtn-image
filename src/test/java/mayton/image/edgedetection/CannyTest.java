package mayton.image.edgedetection;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CannyTest {

    @Test
    void apply() {
        Function<BufferedImage, BufferedImage> function = new Canny();
        BufferedImage image = new BufferedImage(320,200,BufferedImage.TYPE_INT_ARGB);
        assertNotNull(function.apply(image));
    }
}