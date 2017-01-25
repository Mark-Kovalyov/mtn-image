/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.pixels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import mayton.image.IImmutablePixelMatrix;
import mayton.image.Raster;
import mayton.image.bmp.BitmapExportFilter;
import mayton.image.bmp.BitmapImportFilter;
import mayton.image.iterators.IPixIterator;
import mayton.image.iterators.LinearPixIterator;
import mayton.image.procedural.filters.NearestResizeFilter;
import mayton.image.procedural.filters.TestTV16ColorFilter;
import mayton.image.procedural.filters.TestTVUEITRasterFilter;
import mayton.image.procedural.textures.PlasmaFractal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mayton
 */
public class TestRasterFilters {

    static Logger logger = LoggerFactory.getLogger("TestRasterFilters");

    public static void main(String[] args) throws IOException {


        logger.info("Begin");

        String path = System.getProperty("user.home") + "/mayton.image.filters/";
        //String file="1";
        //String file="ph02753u";
        //String file="test8x8";
        String file = "UEIT";
        //String file="test16color";

        BitmapExportFilter bef = BitmapExportFilter.createInstance();

        BitmapImportFilter bif = BitmapImportFilter.createInstance();

        //Raster source=bif.from(new FileInputStream(path+file+".bmp"));

        //NearestResizeFilter nrf = new NearestResizeFilter((IImmutablePixelMatrix)source,2.0);

        //NearestResizeFilter nrf = new NearestResizeFilter(source,1.5);


        bef.export(new TestTVUEITRasterFilter(800, 600), new FileOutputStream(path + "UEIT.filtered.bmp"));

        bef.export(new TestTV16ColorFilter(), new FileOutputStream(path + "16-colors.filtered.bmp"));

        logger.info("End");

    }
}
