package mayton.image.vector;

import java.util.List;
import javax.annotation.concurrent.ThreadSafe;
import mayton.image.Fpoint;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author mayton
 */
@ThreadSafe
public class PolygonalAlgorythms {

    private PolygonalAlgorythms(){}
    
    static boolean isPointIn(@NotNull Fpoint point, @NotNull Fpolygon polygon) {
        if (!polygon.getBoundingBox().isPointInRect(point)){
            return false;
        } else {
            // TODO:
            return true;      
        }
    }
    
    static Fpolygon getConvex(@NotNull List<Fpoint> points) {
        // TODO:
        return new Fpolygon();
    }
    
    static FmultyPolygon fromPolygon(@NotNull Fpolygon polygon) {
        // TODO:
        return new FmultyPolygon();
    }
    
    static FmultyPolygon union(@NotNull Fpolygon polygon1, @NotNull Fpolygon polygon2) {
        // TODO:
        return new FmultyPolygon();
    } 
    
    static FmultyPolygon intersect(@NotNull Fpolygon polygon1, @NotNull Fpolygon polygon2) {
        // TODO:
        
        return new FmultyPolygon();
    }
    
    static FmultyPolygon minus(@NotNull FmultyPolygon polygon) {
        // TODO:
        return new FmultyPolygon();
    }
    
}
