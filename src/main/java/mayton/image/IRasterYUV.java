package mayton.image;

/**
 * Created by IntelliJ IDEA.
 * User: Mayton
 * Date: 08.04.2007
 * Time: 12:15:29
 * To change this template use File | Settings | File Templates.
 */

public interface IRasterYUV {

    int getPixelY(int x,int y);
    int getPixelU(int x,int y);
    int getPixelV(int x,int y);

}
