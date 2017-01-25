package mayton.image.scr;

import mayton.image.Raster;
import mayton.image.RasterImportFilter;

import java.io.InputStream;
import java.awt.Color;

public class SCRImportFilter extends RasterImportFilter
{


    public Raster from(InputStream is) throws java.io.IOException
    {
        Raster img=new Raster(256,192);
        for(int p=0;p<3;p++)
        {
            for(int q=0;q<8;q++)
            {
                for(int r=0;r<8;r++)
                {
                    int i=p<<3+r<<3+q;
                    for(int j=0;j<32;j++){
                        int b=is.read();
                        for(int bit=0;bit<8;bit++)
                        {
                            if ((b&0x80)!=0) img.setPixelRGB(j<<3+bit,i,255,255,255);
                            b<<=1;
                        }
                    }
                }
            }
        }
        Color[] ZXPal={
                new Color(0,0,0),
                new Color(0,0,255),
                new Color(0,255,1),
                new Color(0,255,255),
                new Color(255,0,0),
                new Color(255,0,255),
                new Color(255,255,0),
                new Color(255,255,255),
        };

        for(int i=0;i<24;i++)
        {
            for(int j=0;j<32;j++)
            {
                int b=is.read();
                int col1=b&0x07;
                int col2=(b&0x38)>>3;
                for(int u=0;u<8;u++)
                    for(int v=0;v<8;v++)
                        if (img.getPixel(j<<3+u,i<<3+v)!=0)
                            img.setPixelRGB(
                                j<<3+u,i<<3+v,
                                    ZXPal[col1].getRed(),
                                    ZXPal[col1].getGreen(),
                                    ZXPal[col1].getBlue()
                            );
                        else
                        img.setPixelRGB(
                                j<<3+u,i<<3+v,
                                    ZXPal[col2].getRed(),
                                    ZXPal[col2].getGreen(),
                                    ZXPal[col2].getBlue()
                         );

            }
        }
        return img;
    }
}
