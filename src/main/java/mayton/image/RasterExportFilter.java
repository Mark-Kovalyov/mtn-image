package mayton.image;

import java.io.OutputStream;
import java.io.IOException;
import java.awt.Color;
import java.util.List;

/**
 * RasterExportFilter
 *
 * @author      mayton
 * @license     http://www.gnu.org/licenses/gpl-3.0.html GNU General Public License v3
 */
public class RasterExportFilter {
    /**
     * Получение расширения
     *
     * @return
     */
    public String getExtension() {
        return null;
    }

    /**
     * Экспорт в (предположительно) оригинальном 24Bit формате цвета
     *
     * @param Bitmap
     * @param Fos
     * @return
     * @throws IOException
     */
    public boolean export(IImmutablePixelMatrix Bitmap, OutputStream Fos) throws IOException {
        return false;
    }

    /**
     * Экспорт в (предположительно) 16Bit формате цвета
     *
     * @param Bitmap
     * @param Fos
     * @return
     * @throws IOException
     */
    public boolean export16bit(IImmutablePixelMatrix Bitmap, OutputStream Fos) throws IOException {
        return false;
    }

    /**
     * Экспорт в палитровом формате
     *
     * @param Bitmap
     * @param Palette
     * @param Fos
     * @return
     * @throws IOException
     */
    public boolean export(IImmutablePixelMatrix Bitmap, List<Color> Palette, OutputStream Fos) throws IOException {
        return false;
    }

}
