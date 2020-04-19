package mayton.image.standard;

import mayton.image.Rect;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;

public enum Resolutions {

    ELEKTRONIKA_BK_0010_1(512, 256, EMPTY_LIST ), // B&W
    ELEKTRONIKA_BK_0010_2(256, 256, EMPTY_LIST ), // Color
    RADIO_86_RK(128, 60, EMPTY_LIST ),

    // Slow-scan television
    SSTV_1(128, 128, EMPTY_LIST ),
    SSTV_2(256, 128, EMPTY_LIST ),
    SSTV_3(128, 256, EMPTY_LIST ),
    SSTV_4(256, 256, EMPTY_LIST ),

    // Nindendo consoles
    NINDENDO_PAL(256, 240, asList(new ColorMode(48))),           // 48 colors (*)
    NINDENDO_NTSC(256, 224, EMPTY_LIST ),          // 48 colors (*)
    SUPER_NINDENDO(512, 478, EMPTY_LIST ),         // (512|256) x (224|239|448|478, EMPTY_LIST ), 32768 colors
    SINCLAIR(256, 192, asList(new ColorMode(16))), // 2 of 16 per char position (8x8) colors

    // IBM/PC
    CGA(320, 200, asList(new PaletteColorMode(4,16))),
    SEGA_MEGA_DRIVE_NTSC(320, 224, asList(new PaletteColorMode(64,512))),   // 64 colors from palette of 512
    SEGA_MEGA_DRIVE_PAL(320, 240, asList(new PaletteColorMode(64,512))),   // 64 colors from palette of 512
    QVGA(320, 240, EMPTY_LIST ),                   // 4:3
    VGA(640, 480, EMPTY_LIST ),                    // 4:3
    NTSC(720, 480, EMPTY_LIST ),                   // DVD/VHS/60 fps
    PAL(720, 576, EMPTY_LIST ),                    // DVD/VHS/50 fps
    SVGA(800, 600, EMPTY_LIST ),                   // 4:3
    XGA(1024, 768, EMPTY_LIST ),                   // 4:3
    XGA_864(1152, 864, EMPTY_LIST ),
    HD_720(1280, 720, asList(ColorMode.COLOR_MODE_16M)),                // 16:9
    XGA_960(1280, 960, EMPTY_LIST ),               // 4:3
    CONSUMER_HDV(1440, 1080, EMPTY_LIST ),

    // Top rated!
    FULL_HD(1920, 1080, asList(ColorMode.COLOR_MODE_16M)),              // 16:9 (top rated!)
    CLASSIC_NOTEBOOK(1366, 768, asList(ColorMode.COLOR_MODE_16M)),      //
    OLD_MONITOR_4x5(1280, 1024, asList(ColorMode.COLOR_MODE_16M)),      //

    // https://www.pcmag.com/encyclopedia/term/57419/4k-resolution
    CINEMA_2K_ANAMORPHIC(2048, 858, asList(ColorMode.COLOR_MODE_16M)),
    CINEMA_ACADEMY_2K_STANDARD(1828, 1332, asList(ColorMode.COLOR_MODE_16M)),
    CINEMA_ACADEMY_2K_FLAT(1998, 1080, asList(ColorMode.COLOR_MODE_16M)),
    // 4k
    CINEMA_ACADEMY_4K_STANDARD(3626, 2664, asList(ColorMode.COLOR_MODE_16M)),
    CINEMA_ACADEMY_4K_FLAT(3996, 2160, asList(ColorMode.COLOR_MODE_16M)),
    CINEMA_4K_ANAMORPHIC(4096, 1714, asList(ColorMode.COLOR_MODE_16M)),
    QUAD_4K(3840, 2160, asList(ColorMode.COLOR_MODE_16M)),              // 16:9
    FULL_4K(4096, 2160, asList(ColorMode.COLOR_MODE_16M));

    public final int x;
    public final int y;
    public final String ratio;

    private final Collection<ColorMode> colorModes;

    Resolutions(int x, int y, Collection<ColorMode> colorModes){
        this.x = x;
        this.y = y;
        this.colorModes = colorModes;
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
