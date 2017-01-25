package mayton.image.jpeg;

import java.io.*;
import mayton.image.*;
import mayton.image.iterators.*;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.FileHandler;

import mayton.math.*;

/*
  04.11.2006      mayton.     JPEGExportFilter ......... singleton
  05.11.2006      mayton.     ..........
  07.11.2006      mayton      getInstance() . export() ......synchronized
*/

public class JPEGExportFilter extends RasterExportFilter
{
	int framesize=0;

    MatrixDCT	        MDCT  =null;

    MatrixQuantization  Mq = null;

	MatrixGeneric	    MRes;

    Logger              logger=null;

    FileHandler logFile=null;



    protected static JPEGExportFilter instanceFilter;

    protected JPEGExportFilter()
    {
        logger=Logger.getLogger("JPEGExportFilterLogger");
        logger.setLevel(Level.CONFIG);
        framesize=8;
        logger.info("MatrixDCT creation");
        MDCT  =new MatrixDCT(framesize);
        logger.info("OK");
        logger.config(MDCT.toString());

        logger.info("MatrixQuantization creation");
        Mq  =new MatrixQuantization(framesize,2);
        logger.info("OK");
        logger.config(Mq.toString());

    }

    public static JPEGExportFilter createInstance()
    {
        if (instanceFilter==null)
        {
            instanceFilter=new JPEGExportFilter();
        }
        return instanceFilter;
    }

    void processYFrame(int xpos,int ypos,Raster Bitmap,DataOutputStream Dos,int framesize) throws IOException
	{

        int xc,yc;
        StringBuffer sb=new StringBuffer();

        sb.append("\nProcessing Y Frame ["+xpos+","+ypos+"]\n\n");

        int x;

        /*

         IMatrix frame=new MatrixAdapterYLayer(Bitmap,xpos,ypos,framesize);

        for(int y=0;y<framesize;y++){
            sb.append("|");
            for(x=0;x<framesize-1;x++)
            {
                sb.append(String.format("%1.4f , ",frame.get(x,y)));
            }
            sb.append(String.format("%1.4f",frame.get(x,y)));
            sb.append("|\n");
        }
        logger.config(sb.toString());

        logger.info("Multiply on DCT");
        IMatrix A=new MatrixGeneric(frame);
        MatrixGeneric gm=MatrixGeneric.mul(A,new AdapterMatrixTransp(MDCT));
        logger.info("OK");
        logger.config(gm.toString());

        IPixIterator lpx=new LinearPixIterator(gm.getX(),gm.getY());

        while(lpx.next())
        {
            Dos.writeDouble(gm.get(lpx.getX(),lpx.getY()));
        }
        */

        //IPixIterator zigzag=new ZigzagPixIterator(framesize);

    }


    void processYLayer(Raster Bitmap,DataOutputStream Dos) throws IOException
    {
        logger.info("Process Y layer");
        int ycount=Bitmap.Y/8;
		int xcount=Bitmap.X/8;
		IPixIterator FrameIterator=new LinearPixIterator(xcount,ycount);
        while(FrameIterator.next())
        {
            int xpos=framesize*FrameIterator.getX();
            int ypos=framesize*FrameIterator.getY();
            processYFrame(xpos,ypos,Bitmap,Dos,framesize);
        }
        logger.info("OK");
    }
    
    public synchronized boolean export(Raster Bitmap,OutputStream Fos)  throws IOException
	{
        DataOutputStream Dos=new DataOutputStream(Fos);

        processYLayer(Bitmap,Dos);


        return true;
	}
}