package mayton.image.tiff;

import mayton.image.iterators.IPixIterator;
import mayton.image.Raster;

import java.io.*;

public class TIFFImportFilter extends mayton.image.RasterImportFilter
{
    protected static TIFFImportFilter instance=null;

    protected TIFFImportFilter()
    {

    }

    public static TIFFImportFilter createInstance()
    {
        if (instance==null)
        {
            instance=new TIFFImportFilter();
        }
        return instance;
    }

    protected void fillspan(Raster r,int x,int y,int length, boolean white)
    {
        if (length==0) return;
        if (white)
            for(int i=0;i<length;i++) r.setPixel(x+i,y,0xFFFFFF);
        else
            for(int i=0;i<length;i++) r.setPixel(x+i,y,0x000000);
    }

    public Raster from(InputStream FIS) throws IOException
	{



        BufferedReader br = new BufferedReader(new InputStreamReader(FIS));



        int x=Integer.valueOf(br.readLine());
        int y=Integer.valueOf(br.readLine());

        Raster r=new Raster(x,y);



        int xx=0;
        int yy=0;

        String s;



        int length=0;
        
        while((s=br.readLine())!=null)
        {
            boolean white=true;
            xx=0;
            String[] lexems=s.split(" ");
            for(String si : lexems)
            {
                length=Integer.valueOf(si);
                fillspan(r,xx,yy,length,white);
                white=white?false:true;
                xx+=length;
            }
            yy++;
        }

        return r;
		
	}
}