package mayton.image.tga;

import java.io.*;
import mayton.image.*;

// 07.11.2006      mayton .......... singleton

public class TGAExportFilter extends RasterExportFilter
{
    static TGAExportFilter inst=null;

    protected TGAExportFilter()
    {

    }

    public synchronized static TGAExportFilter getInstance()
    {
        if (inst==null){
            return new TGAExportFilter();
        }
        return null;
    }

    public String getExtension()
	{
		return ".tga";
	}


    public synchronized boolean export(Raster Bitmap,OutputStream Os) throws IOException
	{
    	return true;
	}
}