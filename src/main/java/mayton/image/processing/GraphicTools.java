package mayton.image.processing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * Набор графических алгоритмов
 *
 * @author mayton
 */
public class GraphicTools {

    static Logger logger = LoggerFactory.getLogger(Class.class);

    public static Circle getAmbientCenter(List<Point2D> points) {
        if (points.size() == 0) throw new RuntimeException("points list must be not empty!");


        if (points.size() == 2) {

        }
        return null;
    }

    /**
     * Получение серединного перпендикуляра к отрезку
     *
     * @return
     */
    public static Ray getMiddlePerpendicular(Snipped snipped) {
        return new Ray(
                new Point2D.Double(
                        (snipped.getA().x + snipped.getB().x) / 2.0,
                        (snipped.getA().y + snipped.getB().y) / 2.0
                ),
                new Point2D.Double(
                        snipped.getB().y - snipped.getA().y,
                        snipped.getB().x - snipped.getA().x
                )

        );
    }

}
