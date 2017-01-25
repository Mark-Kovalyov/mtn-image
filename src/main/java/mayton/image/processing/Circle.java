package mayton.image.processing;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author mayton
 */
public class Circle 
{
        Point2D.Double center;
        double R;

        public Circle(Point2D.Double center, double R) {
            this.center=(Point2D.Double) center.clone();
            this.R=R;
        }
}
