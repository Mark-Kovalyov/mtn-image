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
     * @param bitmap
     * @param os
     * @return
     * @throws IOException
     */
    public boolean export(IImmutablePixelMatrix bitmap, OutputStream os) throws IOException {
        return false;
    }

    /**
     * Экспорт в (предположительно) 16Bit формате цвета
     *
     * @param bitmap
     * @param fos
     * @return
     * @throws IOException
     */
    public boolean export16bit(IImmutablePixelMatrix bitmap, OutputStream fos) throws IOException {
        return false;
    }

    /**
     * Экспорт в палитровом формате
     *
     * @param bitmap
     * @param palette
     * @param os
     * @return
     * @throws IOException
     */
    public boolean export(IImmutablePixelMatrix bitmap, List<Color> palette, OutputStream os) throws IOException {
        return false;
    }

}
