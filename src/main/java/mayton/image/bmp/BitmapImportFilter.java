package mayton.image.bmp;

import mayton.image.Raster;

import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;

import mayton.image.RasterImportFilter;
import org.apache.commons.io.input.SwappedDataInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

/**
 * BitmapImportFilter
 *
 * @author      mayton
 * @license     http://www.gnu.org/licenses/gpl-3.0.html GNU General Public License v3
 */
public class BitmapImportFilter extends RasterImportFilter {

    protected static BitmapImportFilter instance = null;

    public static final short BMP_SIGNATURE        = 0x4D42;
    public static final int   OFFSET_TRUE_COLOR    = 0x00000036;

    static Logger logger =  LoggerFactory.getLogger(BitmapImportFilter.class);

    protected BitmapImportFilter() {
    }

    public static BitmapImportFilter createInstance() {
        if (instance == null) {
            instance = new BitmapImportFilter();
        }
        return instance;
    }

    // TODO: Must be replaced with formula
    protected static int EvenBy4(int i) {
        while ((i % 4) != 0) i++;
        return i;
    }


    protected void readColorTable() throws IOException {
        Color RGBQuadTable = new Color(256);
        // TODO:
        throw new RuntimeException("Not implemented yet!");
    }

    // TODO: Must be added Monochrome, 16-color, 256-color palette modes, 16bit RGB color support
    @Override
    public Raster from(@Nonnull InputStream is) throws IOException {
        logger.debug("from Begin....");
        SwappedDataInputStream sdis=new SwappedDataInputStream(is);
        int buf = 0;
        buf = sdis.readShort();
        if (buf != BMP_SIGNATURE) {
            logger.error("(1)There is a not BMP signature! Aborted");
            return null;
        }
        sdis.readInt();
        sdis.readShort();
        sdis.readShort();
        buf = sdis.readInt();
        //  True Color
        if (buf != OFFSET_TRUE_COLOR) {
            logger.error("(2)There is a not 24 bit color! Aborted.");
            return null;
        }
        int X = 0, Y = 0;
        sdis.readInt();
        X = sdis.readInt();
        Y = sdis.readInt();
        logger.debug("size : {}x{}", X, Y);
        sdis.readShort();
        sdis.readShort();
        sdis.readInt();
        sdis.readInt();
        sdis.readInt();
        sdis.readInt();
        sdis.readInt();
        sdis.readInt();
        Raster raster = new Raster(X, Y);
        int r;
        int g;
        int b;
        int linebufLength = EvenBy4(3 * raster.X);
        byte[] linebuf = new byte[linebufLength];
        for (int y = raster.Y - 1; y >= 0; y--) {
            int count = 0;
            is.read(linebuf, 0, linebufLength);
            for (int x = 0; x < raster.X; x++) {
                b = linebuf[count];
                g = linebuf[count + 1];
                r = linebuf[count + 2];
                raster.setPixelRGB(
                        x, y,
                        ((r < 0) ? r + 256 : r),
                        ((g < 0) ? g + 256 : g),
                        ((b < 0) ? b + 256 : b)
                );
                count++;
                count++;
                count++;
            }
        }
        logger.debug("from End");
        return raster;
    }
}