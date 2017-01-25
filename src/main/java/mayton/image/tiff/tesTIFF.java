package mayton.image.tiff;

import mayton.image.Raster;
import mayton.image.bmp.BitmapImportFilter;
import mayton.image.bmp.BitmapExportFilter;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: mayton
 * Date: 11.02.2008
 * Time: 10:47:47
 * To change this template use File | Settings | File Templates.
 */
public class tesTIFF {


    public static void main(String[] args) throws Exception
    {
        String testimage="c:\\001-1949_floyd";

        Raster r;
        BitmapImportFilter bif=BitmapImportFilter.createInstance();
        TIFFExportFilter tef=TIFFExportFilter.createInstance();
        r=bif.from(new FileInputStream(testimage+".bmp"));
        tef.exportbw(r,new FileOutputStream(testimage+".tiff.txt"));

        TIFFImportFilter tif=TIFFImportFilter.createInstance();

        Raster outRaster=tif.from(new FileInputStream(testimage+".tiff.txt"));

        BitmapExportFilter bef=BitmapExportFilter.createInstance();

        bef.export(outRaster,new FileOutputStream(testimage+".restored.bmp"));

    }


}
