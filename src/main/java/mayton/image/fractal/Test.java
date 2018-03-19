package mayton.image.fractal;

import mayton.image.*;
import mayton.image.bmp.BitmapImportFilter;
import mayton.image.bmp.BitmapExportFilter;
import mayton.math.IMatrix;
import mayton.math.MatrixAdapterAvg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class Test {


    public double getAVG(Raster r, int xx,int yy,int ww,int hh)
    {
        double a=0.0;
        for(int x=xx;x<xx+ww;x++)
        {
            for(int y=yy;y<yy+ww;y++)
            {
                a+=r.getYPixelDouble(x,y);
            }
        }
        return a;
    }

    public double getFourier(Raster r, int xx,int yy,int ww,int hh)
    {
        double a=0.0;
        double fi;
        for(int x=xx;x<xx+ww;x++)
        {
            for(int y=yy;y<yy+ww;y++)
            {
                fi=(Math.PI*xx)/ww;
                a+=fi*r.getYPixelDouble(x,y);
            } 
        }
        return a;
    }



    public static void main(String[] args) throws Exception
    {
        String file="c:\\001-1949";
        String ext=".bmp";
        BitmapImportFilter rif=BitmapImportFilter.createInstance();

        Raster r=rif.from(new FileInputStream(file+ext));



        int Vsize=r.Y;
        int V2size=Vsize/2;

        Raster comp=new Raster(r.X*4,Vsize*3);

        YUVRaster r2=new YUVRaster(r);

        IMatrix  marl=new MatrixAdapterRLayer(r);
        IMatrix  magl=new MatrixAdapterGLayer(r);
        IMatrix  mabl=new MatrixAdapterBLayer(r);

        IMatrix  maul=new MatrixAdapterULayer(r);
        IMatrix  mayl=new MatrixAdapterYLayer(r);
        IMatrix  mavl=new MatrixAdapterVLayer(r);

        BitmapExportFilter bef;
        try (OutputStream f = new FileOutputStream(file + "_grayscale.dat")) {
            int[] Ylevels = new int[r.X];
            int[] Ulevels = new int[r.X];
            int[] Vlevels = new int[r.X];

            int width = r.X;
            int height = r.Y;

            for (int x = 0; x < r.X; x++) {
                for (int y = 0; y < r.Y; y++) {

                    comp.setPixel(x, y, r.getPixel(x, y));
                    double rr = marl.get(x, y);
                    comp.setPixelRGBDouble(x + width, y, rr, rr, rr);
                    double gg = magl.get(x, y);
                    comp.setPixelRGBDouble(x + width * 2, y, gg, gg, gg);
                    double bb = mabl.get(x, y);
                    comp.setPixelRGBDouble(x + width * 3, y, bb, bb, bb);

                    double yy = mayl.get(x, y);
                    comp.setPixelRGBDouble(x, y + height, yy, yy, yy);

                    double uu = maul.get(x, y);
                    comp.setPixelRGBDouble(x + width, y + height, uu, uu, uu);

                    double vv = mavl.get(x, y);
                    comp.setPixelRGBDouble(x + width * 2, y + height, vv, vv, vv);

                }
            }

            System.out.println(r);

            System.out.println(maul);

            int ratio = 8;

            IMatrix avgMatrix = new MatrixAdapterAvg(maul, ratio);

            System.out.println(avgMatrix);

            int Vsize2 = Vsize * 2;


            for (int x = 0; x < avgMatrix.getX(); x++) {
                for (int y = 0; y < avgMatrix.getY(); y++) {
                    double VV = avgMatrix.get(x, y);
                    int xx = x * ratio;
                    int yy = y * ratio;
                    for (int k = 0; k < ratio; k++)
                        for (int j = 0; j < ratio; j++) comp.setPixelRGBDouble(xx + k, yy + j + Vsize2, VV, VV, VV);
                }
            }

            f.close();
        }
        bef = BitmapExportFilter.createInstance();
        //bef.export(r2,new FileOutputStream("c:\\lena_y.bmp"));
        //bef.export(U_layer,new FileOutputStream("c:\\lena_U_layer.bmp"));
        //bef.export(V_layer,new FileOutputStream("c:\\lena_V_layer.bmp"));
        bef.export(comp,new FileOutputStream(file+"_YUVRGB"+ext));





    }

}
