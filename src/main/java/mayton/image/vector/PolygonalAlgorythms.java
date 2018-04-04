package mayton.image.vector;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import mayton.image.Fpoint;

/**
 *
 * @author mayton
 */
@ThreadSafe
public class PolygonalAlgorythms {

    private PolygonalAlgorythms(){}
    
    static boolean isPointIn(@Nonnull Fpoint point,@Nonnull Fpolygon polygon) {
        if (!polygon.getBoundingBox().isPointInRect(point)){
            return false;
        } else {
            // TODO:
            return true;      
        }
    }
    
    static Fpolygon getConvex(@Nonnull List<Fpoint> points) {
        // TODO:
        return new Fpolygon();
    }
    
    static FmultyPolygon fromPolygon(@Nonnull Fpolygon polygon) {
        // TODO:
        return new FmultyPolygon();
    }
    
    static FmultyPolygon union(@Nonnull Fpolygon polygon1, @Nonnull Fpolygon polygon2) {
        // TODO:
        return new FmultyPolygon();
    } 
    
    static FmultyPolygon intersect(@Nonnull Fpolygon polygon1, @Nonnull Fpolygon polygon2) {
        // TODO:
        
        return new FmultyPolygon();
    }
    
    static FmultyPolygon minus(@Nonnull FmultyPolygon polygon) {
        // TODO:
        return new FmultyPolygon();
    }
    
}
