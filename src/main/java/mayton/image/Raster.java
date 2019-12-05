package mayton.image;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;

/**
 * Растр с глубиной цвета 32 бит. (RGB+Alpha)
 * 
 * <PRE>
 * Формат растра ::= 00ggBBrr
 *
 *    RGB -> YUV				| YUV -> RGB
 * ------------------------------------------------------------------------------
 *   Y =  0.299*Red+0.587*Green+0.114*Blue	| Red   = Y+0.000*U+1.140*V
 *   U = -0.147*Red-0.289*Green+0.436*Blue	| Green = Y-0.396*U-0.581*V
 *   V =  0.615*Red-0.515*Green-0.100*Blue	| Blue  = Y+2.029*U+0.000*V
 *
 *
 *   Y = [       0..255.0  ]
 *   U = [ -111.18..111.18 ]
 *   V = [-156.825..156.825]
 *
 *
 *   R = [0..1]
 *   G = [0..1]
 *   B = [0..1]
 *
 *   Y = [0..1]
 *   U = [0..1]
 *   V = [0..1]
 *
 *   H(Hue)         = [0..1] Цветовой тон. Циклически повторяется.
 *                           Можно рассматривать как угол повотора
 *                           цветовой точки вокруг цветового конуса
 *
 *                           0   - прибл.
 *                           1/2 -
 *
 *   S(Saturation)  = [0..1] Насыщенность
 *   V(Value)       = [0..1] Значение
 *
 * ?????? ??????????? ????????????? ???????? ? ??????
 *
 *                 x
 *  +---------------------------+
 *  |FFRRGGBBFFRRGGBB...........|
 * y|...........................|
 *  |...........................|
 *  +---------------------------+
 * 
 *  </PRE>
 *
 * @author mayton
 * @license http://www.gnu.org/licenses/gpl-3.0.html GNU General Public License v3
 */

public class Raster implements IRasterRGB,IPixelMatrix {

    public int X;
    public int Y;
    public int[] pixels;
    public int bgColor;

    public static final double GK=0.587;
    public static final double BK=0.114;
    public static final double RK=0.299;

    /**
     * Конструктор пустой картинки
     */
    public Raster() {
        X = 0;
        Y = 0;
        pixels = null;
        bgColor = 0x000000;
    }

    /**
     * Конструктор растра с заданной длиной и шириной
     * @param x
     * @param y
     */
    public Raster(int x, int y) {
        assert x > 0;
        assert y > 0;
        X = x;
        Y = y;
        pixels = new int[x * y];
        bgColor = 0x000000;
    }

    /**
     * Конструктор растра из массива
     * @param x
     * @param y
     * @param pixels
     */
    public Raster(int x, int y, int[] pixels) {
        assert x > 0;
        assert y > 0;
        assert pixels != null;
        X = x;
        Y = y;
        this.pixels = pixels;
        bgColor = 0x000000;
    }

    /**
     * Конструктор копирования
     * @param raster
     */
    public Raster(Raster raster) {
        assert raster != null;
        X = raster.X;
        Y = raster.Y;
        int count = X * Y;
        pixels = new int[count];
        bgColor = 0x000000;
        for (int i = 0; i < count; i++) {
            pixels[i] = raster.pixels[i];
        }
    }

    /**
     *
     * @param raster
     * @param r
     */
    public Raster(Raster raster, Rectangle r) {
        assert raster != null;
        assert r != null;
        X = r.width;
        Y = r.height;
        int count = X * Y;
        pixels = new int[count];
        bgColor = 0x000000;
        for (int x = 0; x < r.width; x++) {
            for (int y = 0; y < r.height; y++) {
                setPixel(x, y, raster.getPixel(x + r.x, y + r.y));
            }
        }
    }


    /**
     * Копирование растра из RasterObject в this
     * @param
     */
    public void copy(Raster raster) {
        assert raster != null;
        int xmax = min(X, raster.X);
        int ymax = min(Y, raster.Y);
        for (int x = 0; x < xmax; x++) {
            for (int y = 0; y < ymax; y++) {
                setPixel(x, y, raster.getPixel(x, y));
            }
        }
    }

    @Deprecated
    public void copyFrameIntoPos(Raster sourceRastr, Rectangle sourceFrame, int xpos, int ypos) {
        assert sourceRastr != null;
        assert sourceFrame != null;
        for (int x = 0; x < sourceFrame.width; x++) {
            for (int y = 0; y < sourceFrame.height; y++) {
                setPixel(x + xpos, y + ypos, sourceRastr.getPixel(x + sourceFrame.x, y + sourceFrame.y));
            }
        }
    }

    public static void copyImageIntoPos(@NotNull BufferedImage source, @NotNull BufferedImage dest, int xpos, int ypos) {
        checkArgument(source.getWidth() <= dest.getWidth() + xpos);
        checkArgument(source.getHeight() <= dest.getHeight() + ypos);
        for (int y = 0; y < source.getHeight(); y++) {
            for (int x = 0; x < source.getWidth(); x++) {
                dest.setRGB(x + xpos, y + ypos, source.getRGB(x, y));
            }
        }
    }

    public static void copyImageIntoRectWithScaling(@NotNull BufferedImage source, @NotNull BufferedImage dest, @NotNull Rect rect) {
        Graphics2D graphics2D = (Graphics2D) dest.getGraphics();

    }

    /**
     *
     * @param
     * @param r
     */
    public  void copyIntoFrame(Raster raster, Rectangle r)
    {
        // ????????? ?????? r ?? ???????? ????????
        //Rectangle ScanArea=new Rectangle(r.x,r.y,RastrObject.X,RastrObject.Y);
        // ????????? ??????

        /*
        int xmax=min(RastrObject.X,r.width);
        int ymax=min(RastrObject.Y,r.height);

        for(int x=0;x<xmax;x++)
            for(int y=0;y<ymax;y++)
            {
                setPixel(x+r.y,y+r.y,RastrObject.getPixel(x,y));
            }
          */
        /*int xmin=max(0,ScanArea.x);
        int ymin=max(0,ScanArea.y);
        int xmax=min(X,ScanArea.x+ScanArea.width);
        int ymax=min(Y,ScanArea.y+ScanArea.height);

        int xshift=ScanArea.x-r.x;
        int yshift=ScanArea.y-r.y;
        for(int x=0;x<ScanArea.width;x++)
        {
            for(int y=0;y<ScanArea.height;y++) setPixel(x,y,RastrObject.getPixel(x+xshift,y+yshift));
        } */
    }


    /**
     * Установка пиксела с заданным цветом RGB
     * @param x
     * @param y
     * @param R
     * @param G
     * @param B
     */
    public void setPixelRGB(int x, int y, int R, int G, int B) {
        assert x >= 0;
        assert x < this.X;
        assert y >= 0;
        assert y < this.Y;
        R = min(255, max(0, R));
        G = min(255, max(0, G));
        B = min(255, max(0, B));
        pixels[x + y * X] = 0xFF000000 | R << 16 | G << 8 | B;
    }

    /**
     * Установка пиксела с заданным цветом (в нормированном формате RGB)
     * @param x
     * @param y
     * @param R
     * @param G
     * @param B
     */
    public void setPixelRGBDouble(int x, int y, double R, double G, double B) {
        assert x >= 0;
        assert x < this.X;
        assert y >= 0;
        assert y < this.Y;
        int r = (int) (255.0 * min(1.0, max(0.0, R)));
        int g = (int) (255.0 * min(1.0, max(0.0, G)));
        int b = (int) (255.0 * min(1.0, max(0.0, B)));
        pixels[x + y * X] = 0xFF000000 | r << 16 | g << 8 | b;
    }

    /**
     * Установка пиксела в формате YUV
     * @param x
     * @param y
     * @param Y
     * @param U
     * @param V
     */
    public void setPixelYUV(int x, int y, int Y, int U, int V) {
        assert x >= 0;
        assert x < this.X;
        assert y >= 0;
        assert y < this.Y;
        Y = (min(255, max(0, Y)));
        U = (min(111, max(-111, U)));
        V = (min(156, max(-156, V)));
        int r = (int) (Y + 0.000 * U + 1.140 * V);
        int g = (int) (Y - 0.396 * U - 0.581 * V);
        int b = (int) (Y + 2.029 * U + 0.000 * V);
        pixels[x + y * X] = 0xFF000000 | r << 16 | g << 8 | b;
    }

    /**
     * Установка пиксела в нормированном формате HSV (Hue,Saturation,Value)
     * <pre>
     *
     *   _    _
     * R  \__/
     *    __
     * G /  \_/
     *      __
     * B \_/  \
     *
     * </pre>
     * @param x
     * @param y
     * @param H [0..1]
     * @param S [0..1]
     * @param V [0..1]
     */
    public void setPixelHSVDouble(int x, int y, double H, double S, double V) {
        pixels[x + y * X] = getPixelFromHSVDouble(H, S, V);
    }

    /**
     * Получнить упакованное значение (RGB) из вектора (H,S,V)
     * @param H = [0..1)
     * @param S = [0..1)
     * @param V = [0..1)
     * @return
     */
    public static int getPixelFromHSVDouble(double H, double S, double V) {
        assert H >= 0.0 && H < 1.0;
        assert S >= 0.0 && S < 1.0;
        assert V >= 0.0 && V < 1.0;
        int r ;
        int g ;
        int b ;
        double hh, p, q, t, ff;
        int i;
        if (S <= 0.0) {
            r = (int) (255.0 * V);
            g = (int) (255.0 * V);
            b = (int) (255.0 * V);
            return 0xFF000000 | r << 16 | g << 8 | b;
        }
        hh = H;
        if (hh >= 360.0) {
            hh = 0.0;
        }
        hh /= 60.0;
        i = (int) hh;
        ff = hh - i;
        p = V * (1.0 - S);
        q = V * (1.0 - (S * ff));
        t = V * (1.0 - (S * (1.0 - ff)));
        int vint = (int) (255.0 * V);
        int tint = (int) (255.0 * t);
        int pint = (int) (255.0 * p);
        int qint = (int) (255.0 * q);
        switch (i) {
            case 0:
                r = vint;
                g = tint;
                b = pint;
                break;
            case 1:
                r = qint;
                g = vint;
                b = pint;
                break;
            case 2:
                r = pint;
                g = vint;
                b = tint;
                break;

            case 3:
                r = pint;
                g = qint;
                b = vint;
                break;
            case 4:
                r = tint;
                g = pint;
                b = vint;
                break;
            case 5:
            default:
                r = vint;
                g = pint;
                b = qint;
                break;
        }
        // TODO: Implement
        return 0xFF000000 | r << 16 | g << 8 | b;
    }

    /**
     * Установка пиксела в нормированном формате YUV
     * @param x
     * @param y
     * @param Y
     * @param U
     * @param V
     */
    public  void setPixelYUVDouble(int x,int y,double Y,double U,double V) {
        assert x >= 0;
        assert x < this.X;
        assert y >= 0;
        assert y < this.Y;
        Y = (min(1.0, max(0.0, Y)));
        U = (min(1.0, max(0.0, U)));
        V = (min(1.0, max(0.0, V)));
        int r = (int) (255.0 * (Y + 0.000 * U + 1.140 * V));
        int g = (int) (255.0 * (Y - 0.396 * U - 0.581 * V));
        int b = (int) (255.0 * (Y + 2.029 * U + 0.000 * V));
        pixels[x + y * X] = 0xFF000000 | r << 16 | g << 8 | b;

    }

    /**
      * Получение нормированного значения Y пиксела
      * @param x x-??????????
      * @param y y-??????????
      * @return double - ??????? ??????? [0..1]
      */
    public  double getYPixelDouble(int x,int y) {
        int color=getPixel(x,y);
        return Raster.getYPixelDouble(color);
    }

    /**
     * Получение Y из упакованного значения RGB
     * @param color
     * @return
     */
    public static double getYPixelDouble(int color) {
        double res = (GK * ((color & 0x00FF00) >> 8) + BK * (color & 0x0000FF) + RK * ((color & 0xFF0000) >> 16)) / 255.0;
        assert res >= 0.0;
        assert res <= 1.0;
        return res;
    }

        /**
         * Получение нормированного значения V пиксела
         * @param x x-??????????
         * @param y y-??????????
         * @return double - V-?????????
         */
    public double getVPixelDouble(int x,int y) {
        int color=getPixel(x,y);
        return getVPixelDouble(color);
    }

    /**
     * Получнить нормированное значение V-компоненты пиксела
     * @param color
     * @return
     */
    public static double getVPixelDouble(int color) {
        double res=
             ( 0.615 * (color&0xFF)
              -0.515 * ((color&0xFF0000)>>16)
              -0.1   * ((color&0xFF00)>>8) + 156.825) / 313.65;
        assert res >= 0.0;
        assert res <= 1.0;
        return res;
    }

    /**
     * Конвертация упакованного значения (RGB) в значение Value (V)
     * @param color
     * @return
     */
    public static int getVPixel(int color) {
        int res = (int)
                (0.615 * (color & 0xFF)
               - 0.515 * ((color & 0xFF0000) >> 16)
                 - 0.1 * ((color & 0xFF00) >> 8));
        assert res > -157;
        assert res < 157;
        return res;
    }

        /**
         * Получнить нормированное значение U-компоненты пиксела
         *
         * @param x 
         * @param y 
         * @return double - U-?????????
         */
    public double getUPixelDouble(int x,int y) {
        int color=getPixel(x,y);
        return (
                -0.147 * (color & 0xFF)
               - 0.289 * ((color & 0xFF0000) >> 16)
               + 0.436 * ((color & 0xFF00) >> 8) + 111.18) / 222.36;
    }

    /**
     *
     * @param color
     * @return
     */
    public static double getUPixelDouble(int color) {
        return (
                -0.147 * (color & 0xFF)
               - 0.289 * ((color & 0xFF0000) >> 16)
               + 0.436 * ((color & 0xFF00) >> 8) + 111.18) / 222.36;
    }


    /**
     * Получение упакованного значения пиксела
     * @param x
     * @param y
     * @return int
     */
    public int getPixel(int x,int y) {
        assert x >= 0;
        assert x < this.X;
        assert y >= 0;
        assert y < this.Y;
        return pixels[x+y*X];
    }

    /**
     * Get compozite RGB triplet from integer vector (int,int,int)
     * @param R
     * @param G
     * @param B
     * @return int
     */
    public static int getPixel(int R, int G, int B) {
        R = min(255, max(0, R));
        G = min(255, max(0, G));
        B = min(255, max(0, B));
        return 0xFF000000 | R << 16 | G << 8 | B;
    }

    /**
     * Get compozite RGB triplet from normalized vector (double, double, double)
     * @param rd
     * @param gd
     * @param bd
     * @return
     */
    public static int getPixel(double rd, double gd, double bd) {
        int R = (int) (255.0 * min(1.0, max(0.0, rd)));
        int G = (int) (255.0 * min(1.0, max(0.0, gd)));
        int B = (int) (255.0 * min(1.0, max(0.0, bd)));
        return 0xFF000000 | R << 16 | G << 8 | B;
    }

    /**
     * Установить пиксел в формате вектора (R,G,B)
     * @param R
     * @param G
     * @param B
     * @return int
     */
    public final static int getPixel(int R, int G, int B, int A) {
        R = min(255, max(0, R));
        G = min(255, max(0, G));
        B = min(255, max(0, B));
        A = min(255, max(0, A));
        return A << 24 | R << 16 | G << 8 | B;
    }

    /**
     * Установить пиксел в формате упакованного (RGB)
     * @param x
     * @param y
     * @param color
     */
    public void setPixel(int x,int y,int color) {
        assert x >= 0;
        assert x < this.X;
        assert y >= 0;
        assert y < this.Y;
        pixels[x + y * X] = color;
    }

    /**
     * Получение G-компоненты из упакованного RGB
     * @param color
     * @return int
     */
    public final static int getGPixel(int color) {
        return (0x0000FF00&color)>>8;
    }

    /**
     * Получение G-компоненты пиксела
     * @param x
     * @param y
     * @return int
     */
    public int getGPixel(int x,int y) {
        int color=getPixel(x,y);
        return Raster.getGPixel(color);
    }

    /**
     * Получение B-компоненты из упакованного (RGB)
     * @param color
     * @return
     */
    public static int getBPixel(int color) {
        return (0x000000FF&color);
    }

    /**
     * Получение G-компоненты пиксела
     * @param x
     * @param y
     * @return int
     */
    public int getBPixel(int x,int y) {
        int color=getPixel(x,y);
        return Raster.getBPixel(color);
    }

    /**
     * Получение R-компоненты из упакованного RGB
     * @param color
     * @return
     */
    public static int getRPixel(int color) {
        return (0x00FF0000&color)>>16;
    }

    /**
     * Получение R-компоненты пиксела
     * @param x
     * @param y
     * @return
     */
    public int getRPixel(int x,int y) {
        int color=getPixel(x,y);
        return Raster.getRPixel(color);
    }

    /**
     * Получение U-компоненты пиксела
     * @param x
     * @param y
     * @return
     */
    public int getUPixel(int x,int y) {
        int color=getPixel(x,y);
        return Raster.getUPixel(color);
    }

    /**
     * Получение U-компоненты из упакованного RGB
     * @param color
     * @return
     */
    public final static int getUPixel(int color) {
        int res=(int)
            (-0.147*(color&0xFF)
            -0.289*((color&0xFF0000)>>16)
            +0.436*((color&0xFF00)>>8));
        assert res<=112;
        assert res>=-112;
        return res;
    }

    /**
     * Получение Y-компоненты пиксела
     * @param x
     * @param y
     * @return
     */
    public int getYPixel(int x,int y) {
        int pixel=getPixel(x,y);
        return Raster.getYPixel(pixel);
    }

    /**
     * Получение Y-компоненты из упакованного значения (RGB)
     * @param pixel
     * @return
     */
    public final static int getYPixel(int pixel) {
        int res= (int)(
            0.587*getGPixel(pixel)+
            0.114*getBPixel(pixel)+
            0.299*getRPixel(pixel)
        );
        assert res>=0;
        assert res<256;
        return res;
    }

    /**
     * Получение строкового представления (R,G,B) из (RGB)
     * @param color
     * @return
     */
    public final static String getRGBTextSignature(int color) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(Raster.getRPixel(color));
        sb.append(",");
        sb.append(Raster.getGPixel(color));
        sb.append(",");
        sb.append(Raster.getBPixel(color));
        sb.append(")");
        return sb.toString();
    }

    /**
     * Получение строкового представления (Y,U,V) из (RGB)
     * @param color
     * @return
     */
    public final static String getYUVTextSignature(int color) {
        return "YUV("+Raster.getYPixel(color)+","+Raster.getUPixel(color)+","+Raster.getVPixel(color)+")";
    }

    /**
     * Получение текстового представления (RGB) значения для Web
     * @param color
     * @return
     */
    public final static String getRGBTextSignatureHex(int color) {
        return Integer.toHexString(0xFFFFFF&color).toUpperCase();
    }

    /**
     * Клонирование растра
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Raster(this);
    }

    /**
     * Получение дистанции между двумя цветами
     * @param color1 - упакованное (RGB)
     * @param color2 - упакованное (RGB)
     * @return
     */
    public final static double getDistance(int color1,int color2) {
        double rv = RK * (getRPixel(color1) - getRPixel(color2));
        double gv = GK * (getGPixel(color1) - getGPixel(color2));
        double bv = BK * (getBPixel(color1) - getBPixel(color2));
        return sqrt(rv * rv + gv * gv + bv * bv);
    }

    /**
     * Получение дампа состояния
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Raster : ");
        sb.append("X = " + X + "\n");
        sb.append("Y = " + Y + "\n");
        sb.append("pixels[] = " + pixels.length + "\n");
        return sb.toString();
    }

    /**
     * Конвертация нормированного вектора (Y,U,V) в упакованное (RGB) значение
     * @param Y
     * @param U
     * @param V
     * @return
     */
    public final static int getPixelFromYUVDouble(double Y,double U,double V)
    {
        assert Y >= 0.0;
        assert Y <= 1.0;
        assert U >= 0.0;
        assert U <= 1.0;
        assert V >= 0.0;
        assert V <= 1.0;
        double r = (Y + 1.14 * V);
        double g = (Y - 0.396 * U - 0.581 * V);
        double b = (Y + 2.029 * U);
        return Raster.getPixel((int) (255.0 * r), (int) (255.0 * g), (int) (255.0 * b));
    }

    /**
     * Конвертация вектора (Y,U,V) в упакованое значение (RGB)
     * @param Y
     * @param U
     * @param V
     * @return
     */
    public final static int getPixelFromYUV(int Y,int U,int V)
    {
        assert Y >= 0;
        assert Y < 256;
        assert U >= -112;
        assert U <= 112;
        assert V >= -157;
        assert V <= 157;
        int r = (int) (Y + 1.14 * V);
        int g = (int) (Y - 0.396 * U - 0.581 * V);
        int b = (int) (Y + 2.029 * U);
        return Raster.getPixel(r, g, b);
    }

    /**
     * Returns average color of 2 pixels without alfa
     * @param color1
     * @param color2
     * @return
     */
    public static int avgPixel(int color1, int color2) {
        return getPixel((getRPixel(color1) + getRPixel(color2)) / 2,
                        (getGPixel(color1) + getGPixel(color2)) / 2,
                        (getBPixel(color1) + getBPixel(color2)) / 2);
    }

    /**
     * Returns average color of 3 pixels without alfa
     * @param color1
     * @param color2
     * @return
     */
    public static int avgPixel(int color1, int color2, int color3) {
        return getPixel((getRPixel(color1) + getRPixel(color2) + getRPixel(color3)) / 3.0 / 255.0,
                        (getGPixel(color1) + getGPixel(color2) + getGPixel(color3)) / 3.0 / 255.0,
                        (getBPixel(color1) + getBPixel(color2) + getBPixel(color3)) / 3.0 / 255.0);
    }

    public static boolean isPixelWhite(int color) {
        // TODO: Optimize
        return getVPixelDouble(color) > 0.5;
    }

    public int getWidth() {
        return X;
    }

    public int getHeight() {
        return Y;
    }
}
