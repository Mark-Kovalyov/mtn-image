package mayton.image;

import mayton.image.standard.MobileResolutions;
import mayton.image.standard.Resolutions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScreenResTest {

    @Test
    void mobile() {
        assertEquals("6:13", MobileResolutions.XIAOMI_REDMI_NOTE_9.ratio);
    }

    @Test
    void screen() {
        Resolutions fullhd = Arrays.stream(Resolutions.values()).filter(r -> r.x == 1920 && r.y == 1080).findFirst().get();

        for(Resolutions r : Resolutions.values()) {
            if (r.ratio.equals(fullhd.ratio)) {
                System.out.printf("%s %d x %d %s\n", r.name(), r.x, r.y, r.ratio);
            }
        }
    }

}
