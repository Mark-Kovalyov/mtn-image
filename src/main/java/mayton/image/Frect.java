package mayton.image;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@Immutable
public class Frect {
    
    public final double x1;
    public final double y1;
    public final double x2;
    public final double y2;

    public boolean isPointInRect(double x, double y){
        return x >= x1 && x < x2 && y >= y1 && y < y2;
    }

    public boolean isPointInRect(@Nonnull Fpoint point){
        return point.x >= x1 && point.x < x2 && point.y >= y1 && point.y < y2;
    }

    // TODO: Implement
    public static Frect intersect(@Nonnull Frect r1,@Nonnull Frect r2) {
        
        return null;
    }

    // TODO: Implement
    public static Frect union(@Nonnull Frect r1,@Nonnull Frect r2){
        return null;
    }

    // TODO: Implement
    public static boolean isPointInRect(@Nonnull Fpoint point, @Nonnull Frect rect){
        return false;
    }

    public static @Nonnull Frect createSquare(double x1, double y1,double size){
        return new Frect(x1, y1, x1 + size, y1 + size);
    }

    public Frect(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getWidth(){
        return x2 - x1;
    }

    public double getHeight(){
        return y2 - y1;
    }
}
