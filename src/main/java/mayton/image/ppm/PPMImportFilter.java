package mayton.image.ppm;

import java.io.*;
import mayton.image.*;
import mayton.image.iterators.*;

public abstract class PPMImportFilter extends RasterExportFilter
{
	static final String Digits="0123456789";

	public static String readLexem(BufferedReader Br) throws IOException
	{		
		StringBuffer Sb=new StringBuffer();
		char c;
		int i;
		int state=0;
		while(true)
		{     
			i=Br.read();
			if (i==-1) break;			
			if (state==0)
			{
				if (Digits.indexOf(i)>=0)
				{
					Sb.append((char)i);				
					state=1;
				}
			}
			else
			{
				if (Digits.indexOf(i)>=0)
				{
					Sb.append((char)i);
				}
				else
				{
					break;
				}
			}			
		}
		return Sb.toString();
	}

	public static Raster from(InputStream Fis) throws IOException
	{
	        Raster r=null;
		InputStreamReader Isr=new InputStreamReader(Fis);
		BufferedReader Br=new BufferedReader(Isr);
		String s=readLexem(Br);
		if (s.compareTo("P3")==-1) return null;
		int x=Integer.parseInt(readLexem(Br));
		int y=Integer.parseInt(readLexem(Br));
		s=readLexem(Br);
		r=new Raster(x,y);
		if (s.compareTo("255")==-1) return null;
		LinearPixIterator Lpi=new LinearPixIterator(x,y);
		while(Lpi.next())
		{		
			r.setPixelRGB(
				Lpi.getX(),
				Lpi.getY(),
				Integer.parseInt(readLexem(Br)),
				Integer.parseInt(readLexem(Br)),
				Integer.parseInt(readLexem(Br))
			);
		}		
		return r;
	}
}