package mayton.image.standard;

import mayton.image.Rect;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public enum Resolutions {

    CGA(320, 200),
    QVGA(320, 240),                   // 4:3
    VGA(640, 480),                    // 4:3
    NTSC(720, 480),
    PAL(720, 576),
    SVGA(800, 600),                   // 4:3
    XGA(1024, 768),                   // 4:3
    XGA_864(1152, 864),
    HD_720(1280, 720),                // 16:9
    XGA_960(1280, 960),               // 4:3
    CONSUMER_HDV(1440, 1080),
    FULL_HD(1920, 1080),              // 16:9

    // https://www.pcmag.com/encyclopedia/term/57419/4k-resolution
    CINEMA_2K_ANAMORPHIC(2048, 858),
    CINEMA_ACADEMY_2K_STANDARD(1828, 1332),
    CINEMA_ACADEMY_2K_FLAT(1998, 1080),
    // 4k
    CINEMA_ACADEMY_4K_STANDARD(3626, 2664),
    CINEMA_ACADEMY_4K_FLAT(3996, 2160),
    CINEMA_4K_ANAMORPHIC(4096, 1714),
    QUAD_4K(3840, 2160),              // 16:9
    FULL_4K(4096, 2160);

    public final int x;
    public final int y;
    public final String ratio;

    Resolutions(int x, int y){
        this.x = x;
        this.y = y;
        BigInteger xx = BigInteger.valueOf(x);
        BigInteger yy = BigInteger.valueOf(y);
        BigInteger gcd = xx.gcd(yy);
        this.ratio = String.format("%s:%s", xx.divide(gcd).toString(), yy.divide(gcd).toString());
    }

    @NotNull
    public Rect createRectangle() {
        return new Rect(0, 0, x, y);
    }

}
