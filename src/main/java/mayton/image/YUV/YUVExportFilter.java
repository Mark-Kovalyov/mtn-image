package mayton.image.YUV;

import java.io.*;
import mayton.image.*;
import mayton.image.iterators.*;



public class YUVExportFilter extends RasterExportFilter
{
    protected static YUVExportFilter instanceFilter=null;

    protected YUVExportFilter()
    {

    }

    public static YUVExportFilter getInstance()
    {
        if (instanceFilter==null)
        {
            instanceFilter=new YUVExportFilter();
        }
        return instanceFilter;
    }

    @Override
    public String getExtension()
    {
		return ".yuv";
    }

    @Override
    public boolean export(IImmutablePixelMatrix bitmap, OutputStream Os) throws IOException
    {
                int xsize= bitmap.getWidth();
                int ysize= bitmap.getHeight();
		IPixIterator i=new LinearPixIterator(xsize,ysize);
		while(i.next())
		{
			int x=i.getX();
			int y=i.getY();
			double Y=Raster.getYPixelDouble(bitmap.getPixel(x,y));
			double U=Raster.getUPixelDouble(bitmap.getPixel(x,y));
			double V=Raster.getVPixelDouble(bitmap.getPixel(x,y));
			Os.write((int)(255.0*Y));
			Os.write((int)(255.0*U));
			Os.write((int)(255.0*V));
		}		
		return true;
    }
}