/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.processing;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Snipped {

    public Double getA() {
        return A;
    }

    public void setA(Double A) {
        this.A = A;
    }

    public Double getB() {
        return B;
    }

    public void setB(Double B) {
        this.B = B;
    }

    public Snipped(Double A, Double B) {
        this.A = A;
        this.B = B;
    }

    Point2D.Double A;
    Point2D.Double B;



}
