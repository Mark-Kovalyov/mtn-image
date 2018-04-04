package mayton.image;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.annotation.Nonnull;

@Immutable
public class Rect {

    public final int x1;
    public final int y1;
    public final int x2;
    public final int y2;

    public boolean isPointInRect(int x, int y){
        return x >= x1 && x < x2 && y >= y1 && y < y2;
    }

    public boolean isPointInRect(@Nonnull Point point){
        return point.x >= x1 && point.x < x2 && point.y >= y1 && point.y < y2;
    }

    // TODO: Implement
    public static Rect intersect(@Nonnull Rect r1,@Nonnull Rect r2){
        
        return null;
    }

    // TODO: Implement
    public static Rect union(@Nonnull Rect r1,@Nonnull Rect r2){
        return null;
    }

    // TODO: Implement
    public static boolean isPointInRect(@Nonnull Point point, @Nonnull Rect rect){
        return false;
    }

    public static @Nonnull Rect createSquare(int x1, int y1,int size){
        return new Rect(x1, y1, x1 + size, y1 + size);
    }

    public Rect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getWidth(){
        return x2 - x1;
    }

    public int getHeight(){
        return y2 - y1;
    }
}
