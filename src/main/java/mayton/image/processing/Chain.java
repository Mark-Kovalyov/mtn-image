/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.processing;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

/**
 *
 * @author mayton
 */
public class Chain {

    protected List<Point2D.Double> points;

    public void add(Point2D.Double point)
    {
        points.add(point);
    }


}
