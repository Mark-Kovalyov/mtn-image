package mayton.image.tga;

import java.io.InputStream;
import java.io.IOException;

import mayton.image.*;

/**
 *
 */

public class TGAImportFilter extends RasterImportFilter
{
    protected static TGAImportFilter instance=null;

    protected TGAImportFilter()
    {

    }

    public static TGAImportFilter createInstance()
    {
        if (instance==null)
        {
            instance=new TGAImportFilter();
        }
        return instance;
    }

    public Raster from(InputStream FIS) throws IOException
	{
        int X;
        int Y;

        int linebuf_length=0;

        //InvertDataInputStream idis=new InvertDataInputStream(FIS);
        // 
		/*X=idis.readInt(FIS);
		Y=idis.readInt(FIS);


		byte[] linebuf=new byte[linebuf_length];
		for(int y=Rastr1.Y-1;y>=0;y--)
		{
			int count=0;
			FIS.read(linebuf,0,linebuf_length);
			for(int x=0;x<Rastr1.X;x++)
			{
				b=linebuf[count];   
				g=linebuf[count+1]; 
				r=linebuf[count+2]; 
				Rastr1.setPixelRGB(
					x,y,
					((r<0)?r+256:r),
					((g<0)?g+256:g),
					((b<0)?b+256:b)
				);				
				count++;
				count++;
				count++;
			}
		}*/
		
		return null;		
	}
}