/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mayton.image.fractal;

import mayton.image.Raster;


/**
 * Аттрактор Лоренца (от англ. to attract - притягивать) ― компактное инвариантное
 * множество L в трехмерном фазовом пространстве гладкого потока, которое имеет
 * определённую сложную топологическую структуру и является асимптотически устойчивым,
 * оно устойчиво по Ляпунову и все траектории из некоторой окрестности ~L
 * стремятся к ~L при ~t\to\infty (отсюда название).
 * <p>
 * Аттрактор Лоренца был найден в численных экспериментах Лоренца, исследовавшего
 * поведение траекторий нелинейной системы:
 *
 * @author mayton
 */
public class LorenzAttractor implements Runnable {

    boolean stopped = false;

    Raster r;

    Thread t;

    public LorenzAttractor(Raster r) {
        assert (r != null);
        this.r = r;
        t = new Thread(this);
        t.start();
    }

    public synchronized void stop() {
        stopped = true;
    }

    public void run() {

        double x = 3.051522, y = 1.582542, z = 15.62388, x1, y1, z1;
        double dt = 0.0001;
        int a = 5, b = 15, c = 1;

        while (!stopped) {
            x1 = x + a * (-x + y) * dt;
            y1 = y + (b * x - y - z * x) * dt;
            z1 = z + (-c * z + x * y) * dt;
            x = x1;
            y = y1;
            z = z1;
            r.setPixel(
                    (int) (19.3 * (y - x * 0.292893) + 320),
                    (int) (-11 * (z + x * 0.292893) + 392),
                    0xFFFFFFFF
            );
        }
    }

    public synchronized Raster getRaster() {
        if (stopped) {
            return r;
        }
        return null;
    }

}
