package mayton.image.bmp;

import java.io.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import mayton.image.*;
import org.apache.commons.io.EndianUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Windows Bitmap (BMP) familly export filter
 *
 * @author      mayton
 * @license     http://www.gnu.org/licenses/gpl-3.0.html GNU General Public License v3
 */

public class BitmapExportFilter extends RasterExportFilter {

    static Logger logger = LoggerFactory.getLogger(BitmapExportFilter.class);

    class BitmapHeader implements Externalizable {

        public BitmapHeader(int biWidth, int biHeight) {
            this.biWidth = biWidth;
            this.biHeight = biHeight;
            bfSize = EvenBy4(biWidth * 3) * biHeight + 14 + 40;
        }

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeShort(BitmapImportFilter.BMP_SIGNATURE);
            out.writeInt(bfSize);
            out.writeShort(0x0000);
            out.writeShort(0x0000);
            out.writeInt(BitmapImportFilter.OFFSET_TRUE_COLOR);
            out.writeInt(biSize);
            out.writeInt(biWidth);
            out.writeInt(biHeight);
            out.writeShort(biPlanes);
            out.writeShort(biBitCount);
            out.writeInt(biCompression);
            out.writeInt(biSizeImage);
            out.writeInt(biXPelsPerMeter);
            out.writeInt(biYPelsPerMeter);
            out.writeInt(biClrUsed);
            out.writeInt(biClrImportant);
        }
        int biWidth;
        int biHeight;
        final short biPlanes = 1;                    // 01 00
        final short biBitCount = 24;                // 18 00
        final int biCompression = 0;                // 00 00 00 00
        final int biSizeImage = 0;                    // 00 00 00 00
        final int biXPelsPerMeter = 0;                // 00 00 00 00
        final int biYPelsPerMeter = 0;                // 00 00 00 00
        final int biClrUsed = 0;                    // 00 00 00 00
        final int biClrImportant = 0;                // 00 00 00 00
        int bfSize;
        final int biSize = 40;
    }

    protected static BitmapExportFilter instanceFilter = null;

    protected BitmapExportFilter() {

    }

    public static BitmapExportFilter createInstance() {
        if (instanceFilter == null) {
            instanceFilter = new BitmapExportFilter();
        }
        return instanceFilter;
    }

    public final int MODE_GRAYSCALE_8BIT = 0;
    public final int MODE_RGB_16BIT = 2;
    public final int MODE_RGB_24BIT = 3;
    public final int MODE_RGB_32BIT = 4;

    // TODO: Must be replaced with correct constants
    public final int OFFSET_8_BIT = 0x0;
    public final int OFFSET_4_BIT = 0x0;
    public final int OFFSET_1_BIT = 0x0;

    // TODO: Must be refactored with formula
    protected int EvenBy4(int i) {
        while ((i % 4) != 0) i++;
        return i;
    }

    @Override
    public String getExtension() {
        return ".bmp";
    }

    /**
     * Export into true-color format
     * @param bitmap
     * @param os
     * @return
     * @throws IOException
     */
    @Override
    public boolean export(IImmutablePixelMatrix bitmap, OutputStream os) throws IOException {

        int X = bitmap.getWidth();
        int Y = bitmap.getHeight();
        logger.debug("export Begin....");
        //InvertDataOutputStream Dos = new InvertDataOutputStream(Fos);
        // TODO: Refactot with Apache Swapped* Streams
        DataOutputStream dos = new DataOutputStream(os);
        //BitmapHeader bh=new BitmapHeader(Bitmap.X,Bitmap.Y);
        //bh.writeExternal(new ObjectOutputStream(Fos));
        int bfSize = EvenBy4(X * 3) * Y + 14 + 40;

        //Dos.writeShort(BMP_SIGNATURE);      // 42 4D
        EndianUtils.writeSwappedShort(os,BitmapImportFilter.BMP_SIGNATURE);
        //Dos.writeInt(bfSize);               // ?? ?? ?? ??
        EndianUtils.writeSwappedInteger(os,bfSize);
        //Dos.writeShort(0x0000);             // 00 00
        EndianUtils.writeSwappedShort(os,(short)0x0000);
        //Dos.writeShort(0x0000);             // 00 00
        EndianUtils.writeSwappedShort(os,(short)0x0000);
        //Dos.writeInt(OFFSET_24_BIT);        // 36 00 00 00
        EndianUtils.writeSwappedInteger(os,BitmapImportFilter.OFFSET_TRUE_COLOR);

        int biSize = 40;                // 28 00 00 00
        int biWidth = X;                // ?? ?? ?? ??
        int biHeight = Y;               // ?? ?? ?? ??
        short biPlanes = 1;             // 01 00
        short biBitCount = 24;          // 18 00
        int biCompression = 0;          // 00 00 00 00
        int biSizeImage = 0;            // 00 00 00 00
        int biXPelsPerMeter = 0;        // 00 00 00 00
        int biYPelsPerMeter = 0;        // 00 00 00 00
        int biClrUsed = 0;              // 00 00 00 00
        int biClrImportant = 0;         // 00 00 00 00

        //Dos.writeInt(biSize);
        //Dos.writeInt(biWidth);
        //Dos.writeInt(biHeight);
        //Dos.writeShort(biPlanes);
        //Dos.writeShort(biBitCount);
        //Dos.writeInt(biCompression);
        //Dos.writeInt(biSizeImage);
        //Dos.writeInt(biXPelsPerMeter);
        //Dos.writeInt(biYPelsPerMeter);
        //Dos.writeInt(biClrUsed);
        //Dos.writeInt(biClrImportant);

        EndianUtils.writeSwappedInteger(os,biSize);
        EndianUtils.writeSwappedInteger(os,biWidth);
        EndianUtils.writeSwappedInteger(os,biHeight);
        EndianUtils.writeSwappedShort(os, biPlanes);
        EndianUtils.writeSwappedShort(os,biBitCount);
        EndianUtils.writeSwappedInteger(os,biCompression);
        EndianUtils.writeSwappedInteger(os,biSizeImage);
        EndianUtils.writeSwappedInteger(os,biXPelsPerMeter);
        EndianUtils.writeSwappedInteger(os,biYPelsPerMeter);
        EndianUtils.writeSwappedInteger(os,biClrUsed);
        EndianUtils.writeSwappedInteger(os,biClrImportant);
        int xtail = EvenBy4(3 * X) - 3 * X;
        logger.debug("size : " + X + " x "+Y);
        os.flush();
        // TODO: Must be optimided with block operations
        for (int y = Y - 1; y >= 0; y--) {
            for (int x = 0; x < X; x++) {
                int rgb = bitmap.getPixel(x, y);
                dos.writeByte(Raster.getBPixel(rgb));
                dos.writeByte(Raster.getGPixel(rgb));
                dos.writeByte(Raster.getRPixel(rgb));
            }
            for (int x = 0; x < xtail; x++) dos.write(0);
        }
        logger.debug("export End");
        return true;
    }

    // TODO: Not implemented yet! Not tested!
    protected void writePalette(List<Color> palette, OutputStream os) throws IOException {
        os.flush();
        DataOutputStream dos=new DataOutputStream(os);
        for (Color c : palette) {
            int color = c.getRGB();
            dos.write(Raster.getRPixel(color));
            dos.write(Raster.getGPixel(color));
            dos.write(Raster.getBPixel(color));
            dos.write(0);
        }
    }

    // TODO: Not tested yet!
    public boolean export16bit(Raster bitmap, OutputStream os) throws IOException {
        assert bitmap!=null : "Argument bitmap cannot be null";
        assert os!=null : "Argument os cannot be null";
        logger.debug("export15bit Begin....");
        for (int x = 0; x < bitmap.X; x++) {
            for (int y = 0; y < bitmap.Y; y++) {
                int pixel = bitmap.getPixel(x, y);
                int r = Raster.getRPixel(pixel);
                int g = Raster.getGPixel(pixel);
                int b = Raster.getBPixel(pixel);
                r >>= 3;
                g >>= 2;
                b >>= 3;
                int res = (r << 11) | (g << 6) | b;
                os.write(0xFFFFFFFF);
            }
        }
        logger.debug("export16bin End");
        return true;
    }

    public boolean export(Raster bitmap, java.util.List<Color> palette, OutputStream os) throws IOException {
        assert bitmap!=null : "Argument bitmap cannot be null";
        assert os!=null : "Argument os cannot be null";
        assert palette!=null : "Argument palette cannot be null";
        //InvertDataOutputStream Dos = new InvertDataOutputStream(Fos);
        DataOutputStream dos = new DataOutputStream(os);
        int bfSize = EvenBy4(bitmap.X * 3) * bitmap.Y + 14 + 40;
        int bfOffbits = BitmapImportFilter.OFFSET_TRUE_COLOR;

        //Dos.writeShort(0x4D42);             // 42 4D
        //Dos.writeInt(bfSize);               // ?? ?? ?? ??
        //Dos.writeShort(0x0000);             // 00 00
        //Dos.writeShort(0x0000);             // 00 00
        //Dos.writeInt(bfOffbits);            // 36 00 00 00

        EndianUtils.writeSwappedShort(os,(short)0x4D42);// 42 4D
        EndianUtils.writeSwappedInteger(os,bfSize);               // ?? ?? ?? ??
        EndianUtils.writeSwappedShort(os,(short)0x0000);             // 00 00
        EndianUtils.writeSwappedShort(os,(short)0x0000);             // 00 00
        EndianUtils.writeSwappedInteger(os,bfOffbits);            // 36 00 00 00

        int biSize = 40;                        // 28 00 00 00
        int biWidth  = bitmap.X;                // ?? ?? ?? ??
        int biHeight = bitmap.Y;                // ?? ?? ?? ??
        short biPlanes = 1;                    // 01 00
        short biBitCount = 24;                // 18 00
        int biCompression = 0;                // 00 00 00 00
        int biSizeImage = 0;                    // 00 00 00 00
        int biXPelsPerMeter = 0;                // 00 00 00 00
        int biYPelsPerMeter = 0;                // 00 00 00 00
        int biClrUsed = 0;                    // 00 00 00 00
        int biClrImportant = 0;                // 00 00 00 00

        /*
        Dos.writeInt(biSize);
        Dos.writeInt(biWidth);
        Dos.writeInt(biHeight);
        Dos.writeShort(biPlanes);
        Dos.writeShort(biBitCount);
        Dos.writeInt(biCompression);
        Dos.writeInt(biSizeImage);
        Dos.writeInt(biXPelsPerMeter);
        Dos.writeInt(biYPelsPerMeter);
        Dos.writeInt(biClrUsed);
        Dos.writeInt(biClrImportant);
        */

        EndianUtils.writeSwappedInteger(os,biSize);
        EndianUtils.writeSwappedInteger(os,biWidth);
        EndianUtils.writeSwappedInteger(os,biHeight);
        EndianUtils.writeSwappedShort(os,biPlanes);
        EndianUtils.writeSwappedShort(os,biBitCount);
        EndianUtils.writeSwappedInteger(os,biCompression);
        EndianUtils.writeSwappedInteger(os,biSizeImage);
        EndianUtils.writeSwappedInteger(os,biXPelsPerMeter);
        EndianUtils.writeSwappedInteger(os,biYPelsPerMeter);
        EndianUtils.writeSwappedInteger(os,biClrUsed);
        EndianUtils.writeSwappedInteger(os,biClrImportant);

        int xtail = EvenBy4(3 * bitmap.X) - 3 * bitmap.X;

        os.flush();
        for (int y = bitmap.Y - 1; y >= 0; y--) {
            for (int x = 0; x < bitmap.X; x++) {
                int rgb = bitmap.getPixel(x, y);
                dos.writeByte((rgb & 0x0000FF));
                dos.writeByte((rgb & 0x00FF00) >> 8);
                dos.writeByte((rgb & 0xFF0000) >> 16);
            }
            for (int x = 0; x < xtail; x++) dos.writeByte(0);
        }

        return true;
    }
}