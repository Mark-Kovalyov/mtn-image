package mayton.image.processing;

import mayton.image.IRasterRGB;

/**
 * Created by IntelliJ IDEA.
 * User: �������������
 * Date: 11.02.2008
 * Time: 16:40:28
 * ����� � ��� ���� ������� , ������� ����� �������������.
 * �� ���� � ��� ���� �����-�� ������������� ������,
 * ������� �� ����� �������� � �����. ���� � ��� ����
 * �������� �������. ������ ���� ��������� � �������
 * (I,J) ��������� � ����� ���� ��������� (X,Y).
 * ������� �������� � ���������. ����� ������� �������
 * � ������ ������������ (X,Y) ����������� ������ �������� �
 *  �������, ������� ������������� ����������� (I,J).
 * ��� ������ ����, ��� ����������� ��������� ������ ,
 * ��������� ��� ��� �������. ���� ������ - ��� ��������
 * �� �������� �� ����� �������� ����� �����. � ������
 * ������ - �������� �� ������� �� ���� ���� ����� �������.
 * ����� ���� ����� ����� ��������� � �����, � ������� ��
 * ����� ����� �� ������ �������� , � ������ �� �������.
 */
public class LensEffect implements Runnable {

    protected Thread t;
    protected IRasterRGB ir;

    LensEffect(IRasterRGB ir)
    {
        this.ir=ir;
    }

    @Override
    public void run()
    {

        //#include <stdio.h>
        //#include <math.h>

        double PI   =   3.1415926;
        double max  =   40.0;

        /*char bmp[64000];
        char Scr[64000];
        char p[1024];
        int  matr[2*max][2*max];
        int  glassnew[2*max][2*max];
        int  glassold[2*max][2*max];*/


        /*
        extern void setvmode(int);
        #pragma aux setvmode = \
          " int 10h " \
          parm [eax] \
          modify exact [eax];


        void wait_retrace()
         {
          while ((inp(0x3DA) & 0x08) == 0);
          while ((inp(0x3DA) & 0x08) != 0);
         }


        void PutPixel(int x,int y,int Color)
         {
           if ((x>0)&&(y>0)&&(x<320)&&(y<200)) Scr[x+y*320]=Color;
         }


        int GetPixel(int x,int y)
         {
           return(bmp[x+y*320]);
         }

        void main(void)
         {
          FILE *f;
          int i,j,xc,yc,c,yc1,xc1,foffset;
          float s,x,y,a,b;

          setvmode(0x13);
          f=fopen("1.bmp", "rb");
          fseek(f,1024+54,0);
          fread(&bmp, 1, 64000, f);
          fseek(f,54,0);
          fread(&p, 1, 1024, f);
          fclose(f);

          // ������� �������
          for(i=0;i<256;i++)
           {
            outp(0x3C8,i);
            outp(0x3C9,p[(i*4)+2] >> 2);
            outp(0x3C9,p[(i*4)+1] >> 2);
            outp(0x3C9,p[(i*4)+0] >> 2);
           }
           // ������� ������� ���������
           for (i=-max;i<max;i++)
           for (j=-max;j<max;j++)
            {
             s=sin(PI/2+(PI/2)/(max*2.2)*sqrt(i*i+j*j));
             x=(i*s);
             y=(j*s);
             glassnew[i+max][j+max]=(int)x+(int)y*320;
             glassold[i+max][j+max]=(i/2)+(j/2)*320;
            }
          do {
           memcpy((char*)&Scr, (char*)&bmp, 64000);
           xc=160+100*cos(2*a)*sin(b);
           yc=100+70*cos(b);
           foffset=xc+yc*320;
           for (i=0;i<2*max;i++)
           for (j=0;j<2*max;j++)
            {
             Scr[foffset+glassnew[i][j]]=bmp[foffset+glassold[i][j]];
            }

           memcpy((char*)0xA0000L, (char*)&Scr, 64000);
           a=a+0.01;
           b=b+0.01;
          } while (!kbhit());
          getch();
          setvmode(0x03);
         }*/

    }




}
