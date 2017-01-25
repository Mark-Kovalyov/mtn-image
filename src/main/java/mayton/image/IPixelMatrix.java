package mayton.image;

/**
 * Created by IntelliJ IDEA.
 * User: Mayton
 * Date: 08.04.2007
 * Time: 15:06:44
 * To change this template use File | Settings | File Templates.
 */
public interface IPixelMatrix extends IImmutablePixelMatrix {
    
    public void setPixel(int x,int y,int color);

}
