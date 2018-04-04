package mayton.image.vector;

import java.util.Iterator;
import mayton.image.Fpoint;
import mayton.image.Frect;
import mayton.image.Point;
import mayton.image.Rect;

/**
 *
 * @author mayton
 */
public interface IPolygon {
    
    boolean isSelfIntersected();
    
    boolean isPointIn(Fpoint point);
    
    void addPoint(Fpoint point);
    
    Frect getBoundingBox();
    
    Iterator<Fpoint> getPoints();
    
    double getSquare();
}
