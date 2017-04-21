/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.pixels;

import mayton.image.GenericRasterFilter;
import mayton.image.IImmutablePixelMatrix;
import mayton.image.Raster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * EPX ("Eric's Pixel eXpansion", пиксельное увеличение Эрика) - алгоритм,
 * разработанный Эриком Джонстоном из LucasArts приблизительно в 1992
 * году[1], при портировании движка SCUMM с IBM PC (разрешение 320×200,
 * 256 цветов) на первые цветные компьютеры Macintosh, где разрешение
 * было выше примерно вдвое.[2]  Алгоритм работает следующим образом:
 * <p>
 * <PRE>
 * A    --\ 1 2
 * C P B  --/ 3 4
 * D
 * Если C==A => 1=A
 * Если A==B => 2=B
 * Если B==D => 4=D
 * Если D==C => 3=C
 * </PRE>
 * Если 3 или более пикселов из A, B, C, D одинаковы: 1=P, 2=P, 3=P, 4=P
 * Последовавшие реализации этого алгоритма (такие как AdvMAME2x и Scale2x,
 * разработаны приблизительно в 2001 году) имеют иную (более эффективную),
 * но функционально идентичную, реализацию:
 * <PRE>
 * A    --\ 1 2
 * C P B  --/ 3 4
 * D
 * <p>
 * 1=P; 2=P; 3=P; 4=P;
 * <p>
 * Если C==A и C!=D и A!=B => 1=A
 * Если A==B и A!=C и B!=D => 2=B
 * Если B==D и B!=A и D!=C => 4=D
 * Если D==C и D!=B и C!=A => 3=C
 * </PRE>
 * <p>
 * AdvMAME4x/Scale4x - это просто дважды примененный EPX.
 * <p>
 * http://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D1%8B_%D0%BC%D0%B0%D1%81%D1%88%D1%82%D0%B0%D0%B1%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F_%D0%BF%D0%B8%D0%BA%D1%81%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D0%B9_%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D0%BA%D0%B8#EPX.2FScale2x.2FAdvMAME2x
 */
public class EPXRasterFilter extends GenericRasterFilter {

    IImmutablePixelMatrix source;

    static Logger logger = LoggerFactory.getLogger(EPXRasterFilter.class);

    public EPXRasterFilter(IImmutablePixelMatrix source) {
        this.source = source;
    }


    public IImmutablePixelMatrix getRaster() {
        int X = source.getWidth();
        int Y = source.getHeight();
        Raster dest = new Raster(X * 2, Y * 2);
        logger.info("Phaze 1");
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                int dpx = x * 2;
                int dpy = y * 2;
                int pixel = source.getPixel(x, y);
                dest.setPixel(dpx, dpy, pixel);
                dest.setPixel(dpx + 1, dpy, pixel);
                dest.setPixel(dpx + 1, dpy + 1, pixel);
                dest.setPixel(dpx, dpy + 1, pixel);
            }
        }
        logger.info("Phaze 2");
        return dest;
    }

    @Override
    public int getProgress() {
        return 100;
    }

    @Override
    public boolean isCached() {
        return false;
    }


}
