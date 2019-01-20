package mayton.image.bmp;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *  BitmapInfoHeader structure
 *
 * BITMAPINFO
 * <PRE>
 * typedef struct tagBITMAPINFO {
 *   BITMAPINFOHEADER bmiHeader;
 *   RGBQUAD          bmiColors[1];
 * } BITMAPINFO, *PBITMAPINFO;
 * </PRE>
 *
 * BITMAPINFOHEADER
 * <PRE>
 * typedef struct tagBITMAPINFOHEADER {
 *   DWORD biSize;
 *   LONG  biWidth;
 *   LONG  biHeight;
 *   WORD  biPlanes;
 *   WORD  biBitCount;
 *   DWORD biCompression;
 *   DWORD biSizeImage;
 *   LONG  biXPelsPerMeter;
 *   LONG  biYPelsPerMeter;
 *   DWORD biClrImportant;
 *   } BITMAPINFOHEADER, *PBITMAPINFOHEADER;
 * </PRE>
 *
 * RGBQUAD
 * <PRE>
 * typedef struct tagRGBQUAD {
 *   BYTE rgbBlue;
 *   BYTE rgbGreen;
 *   BYTE rgbRed;
 *   BYTE rgbReserved;
 * } RGBQUAD;
 * </PRE>
 * @author mayton
 *
 */
// TODO: Not implemented yet!
public class BitmapInfoHeader implements Serializable {

    int biSize;
    int biWidth;
    int biHeight;
    int biPlanes;
    int biBitCount;
    int biCompression;
    int biSizeImage;
    int biXPelsPerMeter;
    int biYPelsPerMeter;
    int biClrUsed;
    int biClrImportant;

    public BitmapInfoHeader(int biSize, int biWidth, int biHeight, int biPlanes, int biBitCount, int biCompression, int biSizeImage, int biXPelsPerMeter, int biYPelsPerMeter, int biClrUsed, int biClrImportant) {
        this.biSize = biSize;
        this.biWidth = biWidth;
        this.biHeight = biHeight;
        this.biPlanes = biPlanes;
        this.biBitCount = biBitCount;
        this.biCompression = biCompression;
        this.biSizeImage = biSizeImage;
        this.biXPelsPerMeter = biXPelsPerMeter;
        this.biYPelsPerMeter = biYPelsPerMeter;
        this.biClrUsed = biClrUsed;
        this.biClrImportant = biClrImportant;
    }

    public void write(OutputStream dos){

    }

    public BitmapInfoHeader read(InputStream is){
        return null;
    }

}
