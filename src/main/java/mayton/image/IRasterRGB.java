package mayton.image;

/**
 * Created by IntelliJ IDEA.
 * User: Mayton
 * Date: 08.04.2007
 * Time: 12:09:18
 * To change this template use File | Settings | File Templates.
 */

public interface IRasterRGB {

    public int getRPixel(int x,int y);
    public int getGPixel(int x,int y);
    public int getBPixel(int x,int y);    

}
