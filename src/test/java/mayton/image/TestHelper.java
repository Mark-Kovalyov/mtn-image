package mayton.image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestHelper {

    private static BufferedImage createColorBar(int width, int height, Color color) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setBackground(color);
        graphics2D.setColor(color);
        graphics2D.fillRect(0,0, width, height);
        return bufferedImage;
    }


}
