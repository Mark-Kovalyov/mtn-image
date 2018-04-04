package mayton.image.vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mayton.image.Fpoint;
import mayton.image.Frect;
import mayton.image.Point;
import mayton.image.Rect;

/**
 *
 * @author mayton
 */
public class Fpolygon implements IPolygon {

    private Frect bbox;
    private List<Fpoint> points = new ArrayList();
    private boolean selfIntersected;

    public static Fpolygon createTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        Fpolygon polygon = new Fpolygon();
        polygon.addPoint(new Fpoint(x1, y1));
        polygon.addPoint(new Fpoint(x2, y2));
        polygon.addPoint(new Fpoint(x3, y3));
        return polygon;
    }

    @Override
    public Frect getBoundingBox() {
        return null;
    }

    @Override
    public Iterator<Fpoint> getPoints() {        
        return points.iterator();
    }

    @Override
    public double getSquare() {
        return 0;
    }

    @Override
    public void addPoint(Fpoint point) {
        points.add(point);
    }

    @Override
    public boolean isSelfIntersected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPointIn(Fpoint point) {
        return PolygonalAlgorythms.isPointIn(point, this);
    }

}
