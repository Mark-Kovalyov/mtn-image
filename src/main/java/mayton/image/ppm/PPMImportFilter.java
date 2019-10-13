package mayton.image.ppm;

import java.io.*;

import mayton.image.*;
import mayton.image.iterators.*;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static java.lang.Integer.parseInt;

public abstract class PPMImportFilter extends RasterExportFilter {

    static final String DIGITS = "0123456789";

    @NotNull
    public static String readLexem(@NotNull BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        int i;
        int state = 0;
        while (true) {
            i = br.read();
            if (i == -1) break;
            if (state == 0) {
                if (DIGITS.indexOf(i) >= 0) {
                    sb.append((char) i);
                    state = 1;
                }
            } else {
                if (DIGITS.indexOf(i) >= 0) {
                    sb.append((char) i);
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }

    @Nullable
    public static Raster from(@NotNull InputStream inputStream) throws IOException {
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String s = readLexem(br);
        if (s.compareTo("P3") < 0) {
            return null;
        }
        int x = parseInt(readLexem(br));
        int y = parseInt(readLexem(br));
        s = readLexem(br);
        Raster r = new Raster(x, y);
        if (s.compareTo("255") < 0) {
            return null;
        }
        LinearPixIterator lpi = new LinearPixIterator(x, y);
        while (lpi.next()) {
            r.setPixelRGB(
                    lpi.getX(),
                    lpi.getY(),
                    parseInt(readLexem(br)),
                    parseInt(readLexem(br)),
                    parseInt(readLexem(br))
            );
        }
        return r;
    }
}