package mayton.image.ppm;

import java.io.*;
import mayton.image.Raster;
import mayton.image.RasterExportFilter;
import mayton.image.iterators.LinearPixIterator;


// 04.11.2006      mayton     PPMExportFilter ....... singleton
// 07.11.2006      mayton     getInstance() . export() ..... synchronized
//                               println .............

public class PPMExportFilter extends RasterExportFilter
{
    protected PPMExportFilter()
    {

    }

    protected static PPMExportFilter instanceFilter=null;

    public synchronized PPMExportFilter createInstance()
    {
        if (instanceFilter==null)
        {
            instanceFilter=new PPMExportFilter();
        }
        return instanceFilter;
    }

    public String  getExtension() {
		return ".ppm";
	}

	public synchronized boolean export(Raster Bitmap,OutputStream Fos) throws IOException
	{
		PrintWriter Pw=new PrintWriter(Fos);		
		Pw.println("P3");
		Pw.print(Bitmap.X);
		Pw.print(" ");
		Pw.println(Bitmap.Y);
		Pw.println("255");	
		LinearPixIterator Lpi=new LinearPixIterator(Bitmap.X,Bitmap.Y);
		while(Lpi.next())
		{
			int pixel=Bitmap.getPixel(Lpi.getX(),Lpi.getY());
			Pw.print(Raster.getRPixel(pixel));
            Pw.print(" ");
            Pw.print(Raster.getGPixel(pixel));
            Pw.print(" ");
            Pw.print(Raster.getBPixel(pixel));
            Pw.print(" ");
        }
		Pw.flush();
		return true;
	}
}