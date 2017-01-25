package mayton.image;

/**
 * Created by IntelliJ IDEA.
 * User: Mayton
 * Date: 08.04.2007
 * Time: 12:15:29
 * To change this template use File | Settings | File Templates.
 */

public interface IRasterYUV {

    public int getPixelY(int x,int y);
    public int getPixelU(int x,int y);
    public int getPixelV(int x,int y);

}
