package mayton.image.tiff;

import mayton.image.RasterExportFilter;
import mayton.image.Raster;

import java.io.*;
import java.util.*;


public class TIFFExportFilter extends RasterExportFilter
{

    protected static TIFFExportFilter instance=null;

    protected TIFFExportFilter()
    {

    }

    public static TIFFExportFilter createInstance()
    {
        if (instance==null)
        {
            instance=new TIFFExportFilter();
        }
        return instance;
    }


        protected static final String[] CCITT3_StopCodes={

        "0,00110101,0000110111",
        "1,00111,010",
        "2,0111,11",
        "3,1000,10",
        "4,1011,011",
        "5,1100,0011",
        "6,1110,0010",
        "7,1111,00011",
        "8,10011,000101",
        "9,10100,000100",
        "10,00111,0000100",
        "11,01000,0000101",
        "12,001000,0000111",
        "13,000011,00000100",
        "14,110100,00000111",
        "15,110101,000011000",
        "16,101010,0000010111",
        "17,101011,0000011000",
        "18,0100111,0000001000",
        "19,0001100,00001100111",
        "20,0001000,00001101000",
        "21,0010111,00001101100",
        "22,0000011,00000110111",
        "23,0000100,00000101000",
        "24,0101000,00000010111",
        "25,0101011,00000011000",
        "26,0010011,000011001010",
        "27,0100100,000011001011",
        "28,0011000,000011001100",
        "29,00000010,000011001101",
        "30,00000011,000001101000",
        "31,00011010,000001101001",
        "32,00011011,000001101010",
        "33,00010010,000001101011",
        "34,00010011,000011010010",
        "35,00010100,000011010011",
        "36,00010101,000011010100",
        "37,00010110,000011010101",
        "38,00010111,000011010110",
        "39,00101000,000011010111",
        "40,00101001,000001101100",
        "41,00101010,000001101101",
        "42,00101011,000011011010",
        "43,00101100,000011011011",
        "44,00101101,000001010100",
        "45,00000100,000001010101",
        "46,00000101,000001010110",
        "47,00001010,000001010111",
        "48,00001011,000001100100",
        "49,01010010,000001100101",
        "50,01010011,000001010010",
        "51,01010100,000001010011",
        "52,01010101,000000100100",
        "53,00100100,000000110111",
        "54,00100101,000000111000",
        "55,01011000,000000100111",
        "56,01011001,000000101000",
        "57,01011010,000001011000",
        "58,01011011,000001011001",
        "59,01001010,000000101011",
        "60,01001011,000000101100",
        "61,00110010,000001011010",
        "62,00110011,000001100110",
        "63,00110100,000001100111"

        };


        protected static final String[] CCITT3_AdvancedCodes={

        "64,11011,0000001111",
        "128,10010,000011001000",
        "192,01011,000011001001",
        "256,0110111,000001011011",
        "320,00110110,000000110011",
        "384,00110111,000000110100",
        "448,01100100,000000110101",
        "512,01100101,0000001101100",
        "576,01101000,0000001101101",
        "640,01100111,0000001001010",
        "704,011001100,0000001001011",
        "768,011001101,0000001001100",
        "832,011010010,0000001001101",
        "896,011010011,0000001110010",
        "960,011010100,0000001110011",
        "1024,011010101,0000001110100",
        "1088,011010110,0000001110101",
        "1152,011010111,0000001110110",
        "1216,011011000,0000001110111",
        "1280,011011001,0000001010010",
        "1344,011011010,0000001010011",
        "1408,011011011,0000001010100",
        "1472,010011000,0000001010101",
        "1536,010011001,0000001011010",
        "1600,010011010,0000001011011",
        "1664,011000,0000001100100",
        "1728,010011011,0000001100101",
        "1792,00000001000,00000001000",
        "1856,00000001100,00000001100",
        "1920,00000001101,00000001101",
        "1984,000000010010,000000010010",
        "2048,000000010011,000000010010",
        "2112,000000010100,000000010100",
        "2176,000000010101,000000010101",
        "2240,000000010110,000000010110",
        "2304,000000010111,000000010111",
        "2368,000000011100,000000011100",
        "2432,000000011101,000000011101",
        "2496,000000011110,000000011110",
        "2560,000000011111,000000011111"
        };



        public String getExtension()
        {
                return ".tif";
        }


        /**
         *
         *
         */

        protected static String[] WhiteCCITT_StopCodes;
        protected static String[] BlackCCITT_StopCodes;
        protected static String[] WhiteCCITT_AdvancedCodes;
        protected static String[] BlackCCITT_AdvancedCodes;

        protected static void InitCCITTEngine()
        {
                WhiteCCITT_StopCodes=new String[64];
                BlackCCITT_StopCodes=new String[64];
                WhiteCCITT_AdvancedCodes=new String[64];
                BlackCCITT_AdvancedCodes=new String[64];
                StringTokenizer St;
                for(int i=0;i<CCITT3_StopCodes.length;i++)
                {
                        St=new StringTokenizer(CCITT3_StopCodes[i],",");
                        St.nextToken();
                        WhiteCCITT_StopCodes[i]=St.nextToken();
                        BlackCCITT_StopCodes[i]=St.nextToken();
                }
                for(int i=0;i<CCITT3_AdvancedCodes.length;i++)
                {
                        St=new StringTokenizer(CCITT3_AdvancedCodes[i],",");
                        St.nextToken();
                        WhiteCCITT_AdvancedCodes[i]=St.nextToken();
                        BlackCCITT_AdvancedCodes[i]=St.nextToken();
                }

        }

        protected static void AddSerial(boolean white,int length,PrintWriter Pw)
        {
                if (white){
                        Pw.print(WhiteCCITT_StopCodes[length%64]);
                }
                else
                {
                        Pw.print(BlackCCITT_StopCodes[length%64]);
                }
        }

        public static boolean exportbw(Raster Bitmap,OutputStream Fos) throws IOException
        {
                assert(Bitmap!=null);
                assert(Bitmap.X>7);
                assert(Bitmap.Y>7);
            
                InitCCITTEngine();

                PrintWriter Pw=new PrintWriter(Fos);

                Pw.printf("%d\n",Bitmap.X);
                Pw.printf("%d\n",Bitmap.Y);

                /*
                for(int y=0;y<Bitmap.Y;y++)
                {
                    for(int x=0;x<Bitmap.X;x++)
                    {
                        int res=Bitmap.getYPixel(x,y);
                        boolean current=(res>128)?true:false;
                        if (current) Pw.printf("1");else Pw.printf("0");
                    }
                    Pw.printf("\n");
                } */

                int length=0;

                for(int y=0;y<Bitmap.Y;y++)
                {
                        boolean prev=true;
                        int res=Bitmap.getYPixel(0,y);
                        boolean current=(res>128)?true:false;
                        if (current!=prev)
                        {
                            Pw.printf("0 ");
                            prev=false;
                            length=1;
                        }
                    
                        for(int x=1;x<Bitmap.X;x++)
                        {
                                res=Bitmap.getYPixel(x,y);
                                current=(res>128)?true:false;

                                if (current!=prev)
                                {
                                        Pw.printf("%d ",length);
                                        prev=(prev)?false:true;
                                        //AddSerial(current,length,Pw);
                                        current=(current)?false:true;
                                        length=0;
                                }
                                length++;
                        }
                        if (length>0)
                        {
                            Pw.printf("%d ",length);
                        }
                        Pw.printf("\n");
                        length=1;
                }



                Pw.flush();

                Pw.close();

                return true;
        }

        
        public static boolean export(Raster Bitmap,FileOutputStream Fos) throws IOException
        {
                return true;
        }
}