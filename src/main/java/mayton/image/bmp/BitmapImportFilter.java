package mayton.image.bmp;

import mayton.image.Raster;

import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;

import mayton.image.RasterImportFilter;
import org.apache.commons.io.input.SwappedDataInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


    /*
    protected static int getInt(InputStream FIS) throws IOException {
        int buf = 0;
        int retval = 0;
        buf = FIS.read();
        retval |= buf & 0xFF;
        buf = FIS.read();
        retval |= (buf & 0xFF) << 8;
        buf = FIS.read();
        retval |= (buf & 0xFF) << 16;
        buf = FIS.read();
        retval |= (buf & 0xFF) << 24;
        return retval;
    }*/

    /*protected static int getShort(InputStream FIS) throws IOException {
        int buf = 0;
        int retval = 0;
        buf = FIS.read();
        retval |= buf & 0xFF;
        buf = FIS.read();
        retval |= (buf & 0xFF) << 8;
        return retval;
    }*/

    // TODO: Must be replaced with formula
    protected static int EvenBy4(int i) {
        while ((i % 4) != 0) i++;
        return i;
    }

    // TODO: Not implemented yet!
    protected void readColorTable() throws IOException {
        Color RGBQuadTable = new Color(256);
        throw new RuntimeException("Not implemented yet!");
    }

    // TODO: Must be added Monochrome, 16-color, 256-color palette modes, 16bit RGB color support
    @Override
    public Raster from(InputStream is) throws IOException {
        assert is != null;
        logger.debug("from Begin....");
        SwappedDataInputStream sdis=new SwappedDataInputStream(is);
        int buf = 0;
        //buf = getShort(is);
        buf = sdis.readShort();
        if (buf != BMP_SIGNATURE) {
            logger.error("(1)There is a not BMP signature! Aborted");
            return null;
        }
        //getInt(is);
        sdis.readInt();
        //getShort(is);
        sdis.readShort();
        //getShort(is);
        sdis.readShort();
        //buf = getInt(is);
        buf = sdis.readInt();
        //  True Color
        if (buf != OFFSET_TRUE_COLOR) {
            logger.error("(2)There is a not 24 bit color! Aborted.");
            return null;
        }
        int X = 0, Y = 0;
        //getInt(is);
        sdis.readInt();
        //X = getInt(is);
        X = sdis.readInt();
        //Y = getInt(is);
        Y = sdis.readInt();
        logger.debug("size : " + X + " x " + Y);
        //getShort(is);
        sdis.readShort();
        //getShort(is);
        sdis.readShort();
        //getInt(is);
        sdis.readInt();
        //getInt(is);
        sdis.readInt();
        //getInt(is);
        sdis.readInt();
        //getInt(is);
        sdis.readInt();
        //getInt(is);
        sdis.readInt();
        //getInt(is);
        sdis.readInt();
        Raster raster = new Raster(X, Y);
        int r, g, b;
        int linebuf_length = EvenBy4(3 * raster.X);
        byte[] linebuf = new byte[linebuf_length];
        for (int y = raster.Y - 1; y >= 0; y--) {
            int count = 0;
            is.read(linebuf, 0, linebuf_length);
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